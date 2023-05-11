# Learning_and_Living_Platform

A Team Assignment for BUAA-Software_Engineering-2023

2023北航软件工程基础课程大作业

***

**PULL before push**

**推送之前先拉取**

**Clear and meaningful commit message.**

**意义明确的提交说明**

**Use English in file name.**

**文件名使用英语**

---

## Participate 参与项目

First, please use the following command to clone the repository to your local machine.

首先请使用如下命令将仓库克隆到本地。

```cmd
# Git cmd for Windows
H: # Your own drive
cd <Your project parent folder path>
git clone https://github.com/AkashiSensei/Learning_and_Living_Platform.git
```

If you are using VPN, maybe you need to let your Git CMD using proxy.

如果您正在使用 VPN，也许需要让您的 Git 命令行工具使用代理。

```cmd
git config --global http.proxy http://127.0.0.1:7890
git config --global https.proxy https://127.0.0.1:7890
# 7890 is default port for Clash
```



## Dir & Files 目录与文件说明

```
Learning_and_Living_Platform
├─Supporting_documents                 # Some other files
|  ├─Notes.md                              # Some Notes during communication. ONLY CHINESE
│  └─Description.md                        # Requirements from teachers & TA. ONLY CHINESE
├─temp                                 # temp files
├─diagrams                             # vpp project and png files
│  ├─requirement                           # files of requirement stage
│  │  └─sequence_diagram                       #files of sequence diagrams
│  ├─design
│  │  ├─outline                        # diagrams for outline design
│  │  └─detail                         # diagrams for detail design
└─README.md
```

### Supporting_documents

该目录包含了各种在完成作业过程中产生的，需要共享的，但不需要提交的文档。

#### Notes.md  

一些笔记，包含作业提交时间，项目流程，当前进度等等。

#### Description.md  

下发的作业描述文档，可能在与助教的沟通中逐步更新。

### temp

许多临时的不好归类的文件。目前有规格说明书的模板，以及准备给助教评阅的用例们。

### diagrams

存放VPP图的工程文件以及导出的png文件。



## Pictures in Markdown MD文件中的图片

请先将图片上传到仓库，然后将仓库中的图片链接插入Markdown文件。

Please upload the images to the Github first, and then insert the image link on Github into the Markdown file.



## [IEEE](https://en.wikipedia.org/wiki/IEEE) software life cycle

### Wiki

- SQA – [Software quality assurance](https://en.wikipedia.org/wiki/Software_quality_assurance) • [IEEE 730](https://en.wikipedia.org/wiki/Software_quality_assurance)
- SCM – [Software configuration management](https://en.wikipedia.org/wiki/Software_configuration_management) • [IEEE 828](https://en.wikipedia.org/wiki/Software_configuration_management)
- STD – [Software test documentation](https://en.wikipedia.org/wiki/Software_test_documentation) • [IEEE 29119](https://en.wikipedia.org/wiki/Software_test_documentation)
- SRS – [Software requirements specification](https://en.wikipedia.org/wiki/Software_requirements_specification) • [IEEE 29148](https://en.wikipedia.org/wiki/Software_requirements_specification)
- V&V – [Software verification and validation](https://en.wikipedia.org/wiki/Software_verification_and_validation) • [IEEE 1012](https://en.wikipedia.org/wiki/Software_verification_and_validation)
- SDD – [Software design description](https://en.wikipedia.org/wiki/Software_design_description) • [IEEE 1016](https://en.wikipedia.org/wiki/Software_design_description)
- SPM – [Software project management](https://en.wikipedia.org/wiki/Software_project_management) • [IEEE 16326](https://en.wikipedia.org/wiki/Software_project_management)
- SUD – [Software user documentation](https://en.wikipedia.org/wiki/Software_user_documentation) • [IEEE 24748](https://en.wikipedia.org/wiki/Software_user_documentation)
- SRA – [Software reviews and audit](https://en.wikipedia.org/wiki/Software_reviews_and_audit) • [IEEE 1028](https://en.wikipedia.org/wiki/Software_reviews_and_audit)



### We Need

《软件开发计划书》、《需求规格说明书》、《软件设计说明书》、《软件实现说明书》、 《测试报告》、《部署文档》、《用户使用说明书》、《项目总结表》

