插入的文档信息,插入指定对象到指定集合
mongoTemplate.insert(user, COLLECTION_NAME)
获取当前【集合】对应的【所有索引】的【名称列表】
mongoTemplate.getCollection(COLLECTION_NAME).listIndexes()
查询集合中的【全部】文档数据
mongoTemplate.findAll(User.class, COLLECTION_NAME)
根据【文档ID】查询集合中文档数据
mongoTemplate.findById(id, User.class, COLLECTION_NAME);
根据【条件】查询集合中【符合条件】的文档，只取【第一条】数据
mongoTemplate.findOne(query, User.class, COLLECTION_NAME);


AggregateGroupService:
聚合表达式
使用管道操作符 $group 结合表达式操作符$count $max $min $sum $avg $first


什么地方会用到？
使用行业：
游戏场景，使用 MongoDB 存储游戏用户信息，用户的装备、积分等直接以内嵌文档的形式存储，方便查询、更新
物流场景，使用 MongoDB 存储订单信息，订单状态在运送过程中会不断更新，以 MongoDB 内嵌数组的形式来存储，一次查询就能将订单所有的变更读取出来。
社交场景，使用 MongoDB 存储存储用户信息，以及用户发表的朋友圈信息，通过地理位置索引实现附近的人、地点等功能
物联网场景，使用 MongoDB 存储所有接入的智能设备信息，以及设备汇报的日志信息，并对这些信息进行多维度的分析
视频直播，使用 MongoDB 存储用户信息、礼物信息等
商城场景：购物车、浏览历史、