# Jenkins 环境变量
- [Jenkins 环境变量](#jenkins-环境变量)
  - [如何查看 jenkins 系统内置环境变量](#如何查看-jenkins-系统内置环境变量)
  - [读取 jenkins 环境变量](#读取-jenkins-环境变量)
  - [自定义 jenkins 环境变量](#自定义-jenkins-环境变量)
  - [jenkins 环境变量重写规则](#jenkins-环境变量重写规则)
  - [jenkins 中使用 Boolean 值](#jenkins-中使用-boolean-值)
  - [shell 结果赋值给环境变量](#shell-结果赋值给环境变量)

## 如何查看 jenkins 系统内置环境变量
* 可以通过`https://<jenkins_url>/env-vars.html`。
* 通过执行`printenv` shell 命令。
```text
pipeline {
    agent any
  
    stages {
        stage("Env Variables") {
            steps {
                sh "printenv"
            }
        }
    }
}
```

## 读取 jenkins 环境变量
通过`env`可以读取环境变量，但是内置的环境变量可以不用`env`，但是都要用`${}`包围起来。

## 自定义 jenkins 环境变量
1. 声明式`environment{key = value}`。
2. 脚本式`script{env.key = value}`。
3. 内置函数式`withEnv(["key=value"]){}`。
```text
pipeline {
    agent any
    environment {
        key1 = 'val1'
    }
    
    stages {
        stage('Custom Env Variables') {
            environment {
                key2 = 'val2'
            }
            
            steps {
                echo "key1 = ${env.key1}"
                echo "key2 = ${env.key2}"
                
                script {
                    env.key3 = 'val3'
                }
                echo "key3 = ${env.key3}"
                
                withEnv(["key4=val4"]) {
                    echo "key4 = ${env.key4}"
                }
            }
        }
    }
}
```

## jenkins 环境变量重写规则
* `withEnv(["key=value"]){}`可以重写任何环境变量。
* `script{env.key = value}`只能重写脚本式环境变量。

## jenkins 中使用 Boolean 值
如果设置一个变量为`false`，jenkins 会将其转换为字符串。需要调用`toBoolean()`方法转换成真正的布尔类型。
```text
pipeline {
    agent any
    environment {
        flag = false
    }

    stages {
        stage('Custom Env Variables') {
            steps {
                script {
                    if (env.flag) {
                        echo "can output"
                    }

                    if (env.flag.toBoolean()) {
                        echo "can't output"
                    }

                    if (env.flag.toBoolean() == false) {
                        echo "flag is false"
                    }

                    if (!env.flag.toBoolean()) {
                        echo "not flag is true"
                    }
                }
            }
        }
    }
}
```

## shell 结果赋值给环境变量
`sh(script: 'cmd', returnStdout:true)`
```text
pipeline {
    agent any
    environment {
        ls_result = "${sh(script: 'ls -lah', returnStdout: true).trim()}"
    }

    stages {
        stage('Custom Env Variables') {
            steps {
                echo "ls_result = ${env.ls_result}"
            }
        }
    }
}
```