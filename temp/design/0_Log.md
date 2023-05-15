## 15/5 16:00

- request_design: 根据controller和entity的设计完善了request
- 在request,controller部分增加了获取评论和回复列表的部分,并增加了对应的request
- 在request,controller部分增加了取消点赞部分
- 在request和controller部分增加了Stastics模块,增加了若干请求(因为没有仔细讨论过,写的比较简略)
- 在数据库Resource表增加字段title, 并对受影响部分进行修改
- 完善了entity的设计
- 其他微小的改动

修改过后,目前request,controller,service和entity的设计基本保持了完整和一致, 很棒!

TODO:

- [x] Service和Mapper中添加新的方法来满足Controller中Stastics模块的请求
- [ ] 完成（或者全部删除）Controller和Service之间的调用关系的说明(可以在画图的时候顺手完成)

---

### MAKIMA 15/5 18:00

已经对提到的Service进行了更新，但是StatisticController有些实现我仍不清楚，例如：

- 如何获取所有在线人数信息？
- 获取总体信息是把所有其他StatisticService调用一遍吗？
- 具体的一些操作例如“  根据热度对帖子排序并获取”，在Mapper进行排序和整合还是Service里？热度指的是一段时间（TimeRange）内的访问量吗？
- Mapper的设计改动不大，但是有些返回值需要更新同实体类设计一致。

以上。

——生姜烧肉

- [ ] 完成（或者全部删除）Controller和Service之间的调用关系的说明(可以在画图的时候顺手完成)
