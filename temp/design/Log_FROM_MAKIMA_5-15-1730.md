#### Log_FROM_MAKIMA_5-15-17:30

已经对提到的Service进行了更新，但是StatisticController有些实现我仍不清楚，例如：

- 如何获取所有在线人数信息？
- 获取总体信息是把所有其他StatisticService调用一遍吗？
- 具体的一些操作例如“  根据热度对帖子排序并获取”，在Mapper进行排序和整合还是Service里？热度指的是一段时间（TimeRange）内的访问量吗？
- Mapper的设计改动不大，但是有些返回值需要更新同实体类设计一致。

以上。

——生姜烧肉