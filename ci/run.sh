echo "**********************************************************"
echo "*                                                        *"
echo "*    run and test robot                                  *"
echo "*                                                        *"
echo "**********************************************************"
mvn clean test javadoc:javadoc sonar:sonar -Dsonar.host.url=https://sonarcloud.io -Dsonar.organization=noraui -Dsonar.login=$SONAR_TOKEN -B -Dcucumber.options="--tags '@loginLogout or @playToLogoGame or @search'" -Pjavadoc,preIC,scenarioInitiator,ci,unit-tests,postIC -Dmaven.test.failure.ignore=true

curl -s "https://api.travis-ci.org/jobs/${TRAVIS_JOB_ID}/log.txt?deansi=true" > nonaui.log
sleep 15

echo "Log url is https://api.travis-ci.org/jobs/${TRAVIS_JOB_ID}/log.txt?deansi=true"
echo "***************************************************"

counters1=$(sed -n 's:.*<EXPECTED_RESULTS_1>\(.*\)</EXPECTED_RESULTS_1>.*:\1:p' nonaui.log | head -n 1)
echo "******** $counters1"
nb_counters1=$(sed -n ":;s/$counters1//p;t" nonaui.log | sed -n '$=')
echo "********" found $nb_counters1 times

counters2=$(sed -n 's:.*<EXPECTED_RESULTS_2>\(.*\)</EXPECTED_RESULTS_2>.*:\1:p' nonaui.log | head -n 1)
echo "******** $counters2"
nb_counters2=$(sed -n ":;s/$counters2//p;t" nonaui.log | sed -n '$=')
echo "******** found $nb_counters2 times"

echo "***************************************************"

# check if BUILD FAILURE finded in logs
nb_failure=$(sed -n ":;s/BUILD FAILURE//p;t" nonaui.log | sed -n '$=')
if [ "$nb_failure" != "" ]; then
    echo "******** BUILD FAILURE find $nb_failure time in build"
    exit 255
fi

# 2 = 1 (real) + 1 counter (Excel)
if [ "$nb_counters1" == "2" ]; then
    echo "******** All counter is SUCCESS"
else
    echo "******** All counter is FAIL"
    exit 255
fi
if [ "$nb_counters2" == "2" ]; then
    echo "******** All counter is SUCCESS"
else
    echo "******** All counter is FAIL"
    exit 255
fi

exit 0
