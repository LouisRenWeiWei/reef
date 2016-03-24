微软开源的
http://www.ctocio.com/ccnews/13240.html
在本周一的国际知识挖掘与数据发现大会上，微软信息服务首席技术官Raghu Ramakrishnan透露微软计划近期内开放其大数据框架REEF（Retainable Evaluator Execution Framework）。REEF被设计运行于下一代Hadoop资源管理器YARN之上，非常适合运行机器学习任务。

reef2-1-microsoft

资源管理器YARN是Apache hadoop项目的一部分，可以让用户在同一物理集群上运行和管理多种任务（例如批处理MapReduce、用Storm进行流处理或图形处理包）。YARN不但能帮企业整合多个需要管理的系统，还能在同一数据和地点运行多种分析任务。有些情况下，整个工作流都能在单一集群上完成。

但Ramakrishnan指出，有些类型的任务，例如机器学习，对数据移动、任务监控有特殊要求，而且经常需要能够在之前的结果中回滚，并不适合YARN这样的框架。而运行在YARN纸上的REEF能够解决这些问题。

 

reef-slide

根据Ramakrishnan的演讲稿，REEF分为两个主要部分（上图）：

一个是求值器Evaluators，是用来承载REEF服务的容器，另一个是活动代码Activities，是在求值器内部运行的用户代码。

总的来说，REEF是一个很有意义的技术，解决了一些公司长期遗留的难题。值得注意的是，REEF的开源标志着微软对Hadoop（主要通过YARN）及开源社区的战略投入，微软正融入Hadoop开源社区，并试图通过回报社区让自己在开发者眼中变得“性感”起来。

总体来看，微软大数据战略的核心是在Azure上提供Hadoop、机器学习、高性能计算和数据分析服务。因此，微软在大数据技术方面的动作也绝不仅限于与Hortonworks在Hadoop平台上的合作，正如微软技术研究员Dave Campbell所言：“Hadoop只是微软信息生产线迈出的第一步。”而REEF的开源，正是微软打造机器学习业务生态环境的第一步
