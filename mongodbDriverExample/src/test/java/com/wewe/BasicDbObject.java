package com.wewe;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: fei2
 * Date:  18-9-18 上午10:17
 * Description: BasicDbObject 是document 一个子类 代表 bson document
 * Refer To:
 * BsonDocument 低阶api，类型严格；Document 高阶api适合用户使用，类型不严格；
 * 推荐用户使用Document，它提供了大量的操作针对不同的类来代表的BSON document；
 * 其中的一个类，是2.x 使用的个DBObject 接口，而是具体使用BasicDBObject，来完成curd操作。
 * 不在推荐使用BasicDBObject
 * https://arch-long.cn/articles/mongodb/Bson%E5%92%8CDocument.html
 * http://mongodb.github.io/mongo-java-driver/3.0/bson/documents/
 */
public class BasicDbObject {

    private MongoCollection<BasicDBObject> collection;

    @Before
    public void createDatabaseColletionTest(){

        MongoClient mongoClient = new MongoClient( "172.24.4.149" , 27017 );

        MongoDatabase database = mongoClient.getDatabase("myDb");

        // Pass BasicDBObject.class as the second argument
        collection = database.getCollection("test", BasicDBObject.class);

    }

    @Test
    public void basicDObjectTest(){

        // insert a document
        BasicDBObject document = new BasicDBObject("x", 1);
        collection.insertOne(document);
        document.append("x", 2).append("y", 3);

        // replace a document
        collection.replaceOne(Filters.eq("_id",document.get("_id")),document);

        // find documents
        List<BasicDBObject> foundDocument = collection.find().into(new ArrayList<BasicDBObject>());
        for (BasicDBObject doc : foundDocument){
            System.out.println(doc.toJson());
        }
    }
}
