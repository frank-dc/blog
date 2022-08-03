# gitlab 升级
- [gitlab 升级](#gitlab-升级)
	- [概要](#概要)
	- [升级路径](#升级路径)
	- [Troubleshooting](#troubleshooting)
	- [参考文档](#参考文档)

## 概要
升级前注意参考 version-specific changes，比如 [Gitlab 15 specific changes](https://docs.gitlab.com/omnibus/update/gitlab_15_changes.html) 。

如果想要保证代码数据零损失，可以按照下列情况执行。
> 自建IDC服务器
1. 原 gitlab 禁止访问，通过下列命令备份数据，将归档文件拷贝到新机器。
```shell
gitlab-rake gitlab:backup:create
```
2. 新增一台机器，部署同样版本的 gitlab，通过下列命令导入数据，然后根据升级路径进行操作，主要防止升级失败，弄脏数据且无法还原。
```shell
mv xxxxxxxxx_gitlab_backup.tar /var/opt/gitlab/backups
gitlab-rake gitlab:backup:restore BACKUP=xxxxxxxxx
```
3. 新机器升级到目标版本，功能测试OK后，将访问 gitlab 地址的负载均衡 upstream 更换成新机器，解绑老机器。

> 云环境服务器

1. 可以将原 gitlab 实例的硬盘做快照或者打个镜像，保证数据安全。

2. 接下来步骤同`自建IDC服务器`。

## 升级路径
如果不想要停机，请按照官方文档的 [升级路径](https://docs.gitlab.com/ee/update/#upgrade-paths) 进行。

## Troubleshooting
14.0 升级到 14.3 的时候会有 migration 报错（可能有多次），根据提示执行即可，执行完记得`gitlab-ctl reconfigure`。
```text
[14.0.12 -> 14.3.6] 报错：
Caused by:
Expected batched background migration for the given configuration to be marked as 'finished', but it is 'active':	{:job_class_name=>"CopyColumnUsingBackgroundMigrationJob", :table_name=>"ci_builds_metadata", :column_name=>"id", :job_arguments=>[["id"], ["id_convert_to_bigint"]]}

Finalize it manualy by running

	sudo gitlab-rake gitlab:background_migrations:finalize[CopyColumnUsingBackgroundMigrationJob,ci_builds_metadata,id,'[["id"]\, ["id_convert_to_bigint"]]']

```

## 参考文档
* [https://docs.gitlab.com/ee/update/](https://docs.gitlab.com/ee/update/)