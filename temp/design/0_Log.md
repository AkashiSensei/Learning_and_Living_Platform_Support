### 15/5 16:00

- request_design: 根据controller和entity的设计完善了request
- 在request,controller部分增加了获取评论和回复列表的部分,并增加了对应的request
- 在request,controller部分增加了取消点赞部分
- 在request和controller部分增加了Stastics模块,增加了若干请求(因为没有仔细讨论过,写的比较简略)
- 在数据库Resource表增加字段title, 并对受影响部分进行修改
- 完善了entity的设计
- 其他微小的改动

修改过后,目前request,controller,service和entity的设计基本保持了完整和一致, 很棒!

TODO:

- [ ] Service中可能需要添加新的方法来满足Stastics模块的请求

- [ ] 完成Controller和Service之间的调用关系(可以在画图的时候顺手完成)