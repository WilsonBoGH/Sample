def dev() { 
    sh 'mvn clean install package cobertura:cobertura sonar:sonar -Dcobertura.report.format=xml'
    archive 'multi-module/webapp/target/webapp.war'
  try {
        checkpoint('Archived war')
    } catch (NoSuchMethodError _) {
        echo 'Checkpoint feature available in Jenkins Enterprise by CloudBees.'
    }
    step([$class: 'JUnitResultArchiver', testResults: '**/TEST-*.xml'])
}

def staging() {
    deploy 'multi-module/webapp/target/webapp.war', 'staging'
    node("winnode8")
    {
        checkout([$class: 'SubversionSCM', 
                            additionalCredentials: [], 
                            excludedCommitMessages: '', 
                            excludedRegions: '', 
                            excludedRevprop: '', 
                            excludedUsers: '', 
                        filterChangelog: false, 
                            ignoreDirPropChanges: false, 
                            includedRegions: '', 
                            locations: [[credentialsId: 'svn', 
                            depthOption: 'infinity', 
                            ignoreExternalsOption: true, 
                            local: '.', 
                            remote: 'https://192.168.0.32/svn/TrainingProject/WilsonBoAutoTest']], 
                            workspaceUpdater: [$class: 'UpdateUpdater']])
        bat "mvn test" 
        step([$class: 'JUnitResultArchiver', testResults: '**/TEST-*.xml'])
    } 
}

def production() {
    
    try {
        checkpoint('Before production')
    } catch (NoSuchMethodError _) {
        echo 'Checkpoint feature available in Jenkins Enterprise by CloudBees.'
    }
    
    node { 
        deploy 'multi-module/webapp/target/webapp.war', 'production'
        echo 'Deployed to http://localhost:8888/production/'
    }
}

def deploy(war, id) {
    sh "cp ${war} /opt/tomcat/webapps/${id}.war"
}
def undeploy(id) {
    sh "rm /tmp/webapps/${id}.war"
}
return this;