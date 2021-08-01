node {
    stage("checkout autotests repo"){
        git branch: 'master',
        credentialsId: 'b7c7955b-5826-44cc-a70c-6a7e114d1cae',
        url: 'https://github.com/anastasiia-fedirchyk/test-automation-example.git'}
    stage("build"){
        sh "./gradlew clean api-test:assemble"}
    stage("run api tests"){
        sh "./gradlew api-tests:test"}
        }