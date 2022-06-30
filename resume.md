# <img align="left" src="https://github.com/frank-dc/drawpics/blob/main/font/contact.png?raw=true" width="20" height="20" style="margin: 7px" />联系方式<img align="right" src="https://github.com/frank-dc/drawpics/blob/main/avatar.jpg?raw=true#pic_right" width="120" height="160" style="margin: 0px 80px 0 0" />
- 手机： 17621938005
- 邮箱： idengchao@yeah.net
- 微信： gdc-frank

# <img align="left" src="https://github.com/frank-dc/drawpics/blob/main/font/personalInformation.png?raw=true" width="20" height="20" style="margin: 7px" />个人信息
- 邓超/男/1991 
- 统招本科/南京工业大学/热能与动力工程
- 工作年限：7年（5年运维2年开发）
- GitHub：[https://github.com/frank-dc](https://github.com/frank-dc)
- 期望职位：运维开发工程师
- 期望薪资：32K+（详细面聊）
- 期望城市：上海

# <img align="left" src="https://github.com/frank-dc/drawpics/blob/main/font/experience.png?raw=true" width="25" height="25" style="margin: 7px" />工作经历
## <img align="left" src="https://github.com/frank-dc/drawpics/blob/main/font/dingdong.png?raw=true" width="95" height="35" style="margin: -5px 6px 0 0" />(2021年5月 - 至今)[资深SRE工程师]
### <img align="left" src="https://github.com/frank-dc/drawpics/blob/main/font/solidRightArrow.png?raw=true" width="25" height="25" style="margin: 3px 0 0 0" />负责买菜核心链路运维以及参与同城双活改造
::: block-1
运维方面：业务系统运维SOP变更管理，确保系统工作正常运行及故障时的及时响应。

同城双活：上层分片逻辑是通过DNS线路智能解析；业务层是单元化，服务注册网关统一导流，双机房部署做冗余；存储层数据未做双活，读写同一套数据库集群。
:::

### <img align="left" src="https://github.com/frank-dc/drawpics/blob/main/font/solidRightArrow.png?raw=true" width="25" height="25" style="margin: 3px 0 0 0" />参与测试环境marathon迁移腾讯云TKE
::: block-1
在之前的工作经历中容器及K8S接触较少，在这个过程中主要负责编写各类资源通用yaml文件，调用k8s API创建服务，管理POD。

* 熟悉了K8s的整体架构和各个主要组件的作用。
* 掌握了K8s中Service/Deployment/Pod的相关概念。
:::

### <img align="left" src="https://github.com/frank-dc/drawpics/blob/main/font/solidRightArrow.png?raw=true" width="25" height="25" style="margin: 3px 0 0 0" />自建MongoDB/Redis迁移到腾讯云
::: block-1
叮咚前期MongoDB/Redis是通过购买腾讯云CVM部署集群，基于资源及维护成本考虑，全部迁移到腾讯云TencentDB。整个迁移过程，要协调腾讯、研发、运维三方，涉及到架构梳理、资源适配、数据迁移、使用测试、配置更改、功能测试等流程。
:::
### <img align="left" src="https://github.com/frank-dc/drawpics/blob/main/font/solidRightArrow.png?raw=true" width="25" height="25" style="margin: 3px 0 0 0" />成本分析平台开发
::: block-1
整合腾讯云与公司内部接口，按业务部门、资源类型维度统计资源使用率及变化趋势，通过常规压测结果确定各服务占用水位，及时扩缩容，回收闲置资源，方便公司优化资源使用成本。
:::

## <img align="left" src="https://github.com/frank-dc/drawpics/blob/main/font/giantNetwork.jpg?raw=true" width="95" height="35" style="margin: 0 6px 0 0" />(2017年9月 - 2021年4月)[高级运维开发工程师]

### <img align="left" src="https://github.com/frank-dc/drawpics/blob/main/font/solidRightArrow.png?raw=true" width="25" height="25" style="margin: 3px 0 0 0" />负责手游登录充值业务的运维
::: block-1
* 参与手游登录充值服务整体架构的评审、改造优化、容灾演练，满足服务在当时的流量下高可用/高扩展/高性能的要求。

最终整个服务体系部署在上海双IDC，达到同城多活，灵活应对单机房故障，通过ansible可快速横向扩展，压测后性能可达到登录充值业务流量峰值的2倍。
:::
### <img align="left" src="https://github.com/frank-dc/drawpics/blob/main/font/solidRightArrow.png?raw=true" width="25" height="25" style="margin: 3px 0 0 0" />推进日志系统的落地
::: block-1
* 制定日志规范，包括日志级别, 保存路径, 自动切割等
* 部署ELK，通过可视化平台接入，调用ES/企业微信API告警。

极大地提升了日志查看效率，方便相关人员及时、快速排错解决问题，同时也间接加快了研发的迭代效率。
:::

### <img align="left" src="https://github.com/frank-dc/drawpics/blob/main/font/solidRightArrow.png?raw=true" width="25" height="25" style="margin: 3px 0 0 0" />负责运维可视化平台研发
::: block-1
平台实现的功能主要有主机(组)管理，服务管理，发布系统，Ansible可视化，DNS流量管理，业务每日指标报表等[https://github.com/frank-dc/svp](https://github.com/frank-dc/svp)。

平台上线后，发布日可管控，机房故障可快速切流，提炼标准操作流程，规避潜在操作失误风险，提升了运维效率和质量，同时提升了研发的迭代和交付速率。

平台开发采用的技术栈是 Python/Django/jQuery/LayUI/MySQL。
:::

## <img align="left" src="https://github.com/frank-dc/drawpics/blob/main/font/pptv1.png?raw=true" width="95" height="35" style="margin: 0 6px 0 0" />(2016年12月 - 2017年9月)[运维工程师]
### <img align="left" src="https://github.com/frank-dc/drawpics/blob/main/font/solidRightArrow.png?raw=true" width="25" height="25" style="margin: 3px 0 0 0" />电视内容系统和官网首页的运维
::: block-1
PPTV整个运维团队覆盖全面，分别有IDC/网络/系统/安全/业务/DBA/运维开发，从机器虚拟化到初始化到服务部署后续代码配置迭代，都是通过可视化平台完成，流程标准化，包安装文件初始配置通过rpm定制。

* 提升了 nginx 的使用能力，包括 location 正则、rewrite、限流、负载均衡、allow/deny、if。
* 接触到并认识到标准化、可视化运维的重要性，提升运维效率、安全和交付效率。
* 故障响应及时、技术文档整理。
:::

## <img align="left" src="https://github.com/frank-dc/drawpics/blob/main/font/gewara.png?raw=true" width="95" height="35" style="margin: 0 6px 0 0" />(2015年6月 - 2016年12月)[运维工程师]

### <img align="left" src="https://github.com/frank-dc/drawpics/blob/main/font/solidRightArrow.png?raw=true" width="25" height="25" style="margin: 3px 0 0 0" />参与格瓦拉票务系统运维
::: block-1
格瓦拉当时技术粘使用很广泛，WEB: Nginx + Apache，缓存: Varnish/Squid，后端语言: php/java，数据库: MySQL/PostgreSQL/MongoDB，监控：Zabbix/Nagios。

* 学会了常用开源软件的安装（rpm、源码编译、二进制等）和简单配置。
* 提升了 shell 编写能力，学会了更多的 Linux 命令。
* 开始接触 Python，使用常规包编写一些简单的脚本，比如io/os/psutil/requests/json等
:::

### <img align="left" src="https://github.com/frank-dc/drawpics/blob/main/font/solidRightArrow.png?raw=true" width="25" height="25" style="margin: 3px 0 0 0" />线上回收机器kvm虚拟化
::: block-1
非线上环境使用机器数量逐渐增多，线上回收的物理机器首先资源有限不够分配，其次单独划分个人使用资源浪费过于严重，研究了kvm虚拟化，将资源更合理分配，提高了资源利用率，节省了成本。

* 首次接触kvm技术，学会 vurt-install/virt-manager/qemu-img 和 qemu-kvm、virsh 创建 kvm 和管理虚拟机。
* 通过使用python开源项目 webvirtmgr 可视化管理工具，首次接触Python以及Django框架。
* 将公司内部环境资源使用的不同需求落地，提升了资源管理能力和跨部门沟通能力。
:::

# <img align="left" src="https://github.com/frank-dc/drawpics/blob/main/font/certificate.png?raw=true" width="25" height="25" style="margin: 6px" />证书奖项
::: block-1
工学学士学位\大学英语六级\全国计算机C++语言程序设计二级、网络技术三级
:::
# <img align="left" src="https://github.com/frank-dc/drawpics/blob/main/font/thanks.png?raw=true" width="20" height="20" style="margin: 7px" />致谢
::: block-1
感谢您花时间阅读我的简历，期待能有机会和您共事。
:::


