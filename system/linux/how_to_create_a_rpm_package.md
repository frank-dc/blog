# 准备工作
* 安装依赖包
```shell
yum install -y rpmdevtools rpmlint
```
* 创建rpmbuild的工作目录
```shell
rpmdev-setuptree
```
会在~/rpmbuild目录下自动创建以下目录
```
rpmbuild/
├── BUILD
├── RPMS
├── SOURCES
├── SPECS
└── SRPMS
```

# rpmbuild目录结构说明

| 目录       | 宏代码 |   名称 | 功能  |
| :-------- | :---- | :----- | :----|
~/rpmbuid/BUILD |	%_builddir | 构建目录 | 源码包被解压至此，并在该目录的子目录完成编译
~/rpmbuild/RPMS | %_rpmdir | RPM包目录 | 生成、保存不同体系结构构建的 RPM 包
~/rpmbuild/SOURCES |	%_sourcedir	|源代码目录|	保存源码包（.tar.gz或.tgz）和所有patch补丁
~/rpmbuild/SPECS|	%_specdir	|SPEC文件目录	|包含.spec文件，.spec文件定义了包的构建方式
~/rpmbuild/SRPMS|	%_srcrpmdir	|源RPM包目录	|源RPM包不属于架构或发行版，实际的.rpm包构建基于.src.rpm包

# 宏定义
SPEC文件中使用的宏一般是在 rpmrc and macros configuration file(s). 中定义。也可以通过 rpm/rpmbuild --showrc 查看。
```shell
# rpmbuild --showrc |grep topdir
-14: _builddir	%{_topdir}/BUILD
-14: _buildrootdir	%{_topdir}/BUILDROOT
-14: _rpmdir	%{_topdir}/RPMS
-14: _sourcedir	%{_topdir}/SOURCES
-14: _specdir	%{_topdir}/SPECS
-14: _srcrpmdir	%{_topdir}/SRPMS
-14: _topdir	%{getenv:HOME}/rpmbuild
```

<details>
  <summary>rpmrc Configuration</summary>
  
```
/usr/lib/rpm/rpmrc
/usr/lib/rpm/<vendor>/rpmrc
/etc/rpmrc
~/.rpmrc
```
  
</details>

<details>
  <summary>Macro Configuration</summary>

```
/usr/lib/rpm/macros
/usr/lib/rpm/<vendor>/macros
/etc/rpm/macros
~/.rpmmacros
```
  
</details>
  
通过 `rpm/rpmbuild --eval="EXPR"` 可以打印 EXPR 的宏展开，比如
```shell
# rpm --eval="%{_topdir}"
/root/rpmbuild
```
  
# hello.spec样例
将源代码[hello-2.10.tar.gz](http:/ftp.gnu.org/gnu/hello/hello-2.10.tar.gz)放到~/rpmbuild/SOURCES。
  
<details>
  <summary>cat ~/rpmbuild/SPECS/hello.spec</summary>
    
```
Name:       hello
Version:    2.10
Release:    1%{?dist}
Summary:    The "Hello World" program from GNU
 
Group:      GNU
License:    GPLv3+
URL:        http://ftp.gnu.org/gnu/hello
Source0:    http://ftp.gnu.org/gnu/hello/%{name}-%{version}.tar.gz
 
BuildRequires:    gettext
Requires:    info
 
%description
The "Hello World" program, done with all bells and whistles of a proper FOSS
project, including configuration, build, internationalization, help files, etc.
 
%description -l zh_CN
"Hello World" 程序，包含 FOSS 项目所需的所有部分，包括配置，构建，国际化，帮助文档等。
 
%prep
%setup -q
 
 
%build
%configure
make %{?_smp_mflags}
 
 
%install
make install DESTDIR=%{buildroot}
%find_lang %{name}
#rm -f %{buildroot}/%{_infodir}/dir
 
%post
/sbin/install-info %{_infodir}/%{name}.info %{_infodir}/dir || :
 
%preun
if [ $1 = 0 ] ; then
/sbin/install-info -delete %{_infodir}/%{name}.info %{_infodir}/dir || :
 
%files -f %{name}.lang
%doc AUTHORS ChangeLog NEWS README THANKS TODO
%license COPYING
%{_mandir}/man1/hello.1.*
%{_infodir}/hello.info.*
%{_bindir}/hello
 
 
%changelog
* Thu Dec 26 2019 Your Name <youremail@xxx.xxx> - 2.10-1
- update to 2.10
* Sat Dec 3 2016 Your Name <youremail@xxx.xxx> - 2.9-1
- update to 2.9
```
     
</details>
  
# 构建（rpmbuild）
```shell
# rpmbuild -ba hello.spec
```
<details>
  <summary>构建选项</summary>  

```
  -bp                           依据 <specfile> 从 %prep (解压缩源代码并应用补丁) 开始构建
  -bc                           依据 <specfile> 从 %build (%prep 之后编译) 开始构建
  -bi                           依据 <specfile> 从 %install (%prep、%build 后安装) 开始构建
  -bl                           依据 <specfile> 检验 %files 区域
  -ba                           依据 <specfile> 构建源代码和二进制软件包
  -bb                           依据 <specfile> 构建二进制软件包
  -bs                           依据 <specfile> 构建源代码软件包
  -tp                           依据 <tarball> 从 %prep (解压源代码并应用补丁)开始构建
  -tc                           依据 <tarball> 从 %build (%prep，之后编译)开始构建
  -ti                           依据 <tarball> 从 %install (%prep、%build 然后安装)开始构建
  -ta                           依据 <tarball> 构建源代码和二进制软件包
  -tb                           依据 <tarball> 构建二进制软件包
  -ts                           依据 <tarball> 构建源代码软件包
  --rebuild                     依据 <source package> 构建二进制软件包
  --recompile                   依据 <source package> 从 %install (%prep、%build 然后安装)开始构建  
```

</details>
  
# 放置yum仓库
* 从~/rpmbuild/RPMS中拷贝rpm包至下载目录，比如/var/www/yum。
```shell
# cp ~/rpmbuild/RPMS/hello-2.10-1.el7.x86_64.rpm /var/www/yum
```
* 执行createrepo命令。
```shell
# createrepo --update /var/www/yum
```
  
# 客户端
```shell
# yum makecache fast
```

