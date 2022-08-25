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