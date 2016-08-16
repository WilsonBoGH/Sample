
def flow

stage 'Dev'
node("master")
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
                            remote: 'https://192.168.0.32/svn/TrainingProject/WilsonBo']], 
                            workspaceUpdater: [$class: 'UpdateUpdater']])
    flow = load 'flow.groovy'
    
    flow.dev()
}


stage name: 'Staging', concurrency: 1
timeout(time:1, unit:"DAYS")
{
    input message: "Did all dev test pass?"
}
node("master")
{
    flow.staging()
}

stage name: 'Production', concurrency: 1
timeout(time:2, unit:"DAYS")
{
    input message: "Does http://192.168.0.37:8080/staging/ look good?"
}
flow.production()