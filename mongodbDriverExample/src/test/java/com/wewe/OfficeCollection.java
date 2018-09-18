package com.wewe;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.DeleteOneModel;
import com.mongodb.client.model.InsertOneModel;
import com.mongodb.client.model.ReplaceOneModel;
import com.mongodb.client.model.UpdateOneModel;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.excludeId;
import static com.mongodb.client.model.Sorts.descending;

/**
 * Author: fei2
 * Date:  18-9-17 下午4:04
 * Description:
 * Refer To:
 */
public class OfficeCollection {

    private MongoCollection<Document> collection;

    @Before
    public void createDatabaseColletionTest(){

        MongoClient mongoClient = new MongoClient( "172.24.4.149" , 27017 );

        MongoDatabase database = mongoClient.getDatabase("myDb");

        collection = database.getCollection("test");
    }

    /**
     {
         "_id" : ObjectId("5ba05b7a99f3df59d8b0cf58"),
         "name" : "MongoDB",
         "type" : "database",
         "count" : 1,
         "info" : {
                 "x" : 203,
                 "y" : 102
             }
     }
     */
    //document 对应一个json节点
    @Test
    public void insertOneTest(){
        Document doc = new Document("name", "MongoDB")
                .append("type", "database")
                .append("count", 1)
                .append("info", new Document("x", 203).append("y", 102));

        collection.insertOne(doc);
    }

    @Test
    public void insertManyTest(){

        List<Document> documents = new ArrayList<Document>();
        for (int i = 0; i < 100; i++) {
            documents.add(new Document("i", i));
        }
        collection.insertMany(documents);

        System.out.println(collection.count());
    }

    @Test
    public void findTest(){
        Document myDoc = collection.find().first();
        System.out.println(myDoc.toJson());
    }

    @Test
    public void findAll(){
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }

        // or

        for (Document cur : collection.find()) {
            System.out.println(cur.toJson());
        }
        //or
        // find documents
        List<Document> foundDocument = collection.find().into(new ArrayList<Document>());
        for (Document cur : foundDocument) {
            System.out.println(cur.toJson());
        }
    }

    @Test
    public void filterTest(){
        Document myDoc = collection.find(eq("i", 71)).first();
        System.out.println(myDoc.toJson());
    }

    @Test
    public void forEachTest(){
        // now use a range query to get a larger subset
        Block<Document> printBlock = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document.toJson());
            }
        };
        collection.find(gt("i", 50)).forEach(printBlock);
    }

    @Test
    public void sortTest(){
        Document myDoc = collection.find(exists("i")).sort(descending("i")).first();
        System.out.println(myDoc.toJson());
    }
    //投影 查询出；非 id的所有列
    @Test
    public void projectTest(){
        Document myDoc = collection.find().projection(excludeId()).first();
        System.out.println(myDoc.toJson());
    }

    //更新一个
    @Test
    public void updateOneTest(){
        collection.updateOne(eq("i", 1), new Document("$set", new Document("i", 110)));
    }

    @Test
    public void updateMany(){
        UpdateResult updateResult = collection.updateMany(lt("i", 200),
                new Document("$inc", new Document("i", 100)));
        System.out.println(updateResult.getModifiedCount());
    }

    @Test
    public void deleteOneTest(){
        collection.deleteOne(eq("i", 210));
    }
    @Test
    public void deleteManyTest(){
        DeleteResult deleteResult = collection.deleteMany(gte("i", 100));
        System.out.println(deleteResult.getDeletedCount());

    }
    // 零散的操作
    @Test
    public void bulkTest(){
        collection.bulkWrite(
                Arrays.asList(new InsertOneModel<>(new Document("_id", 4)),
                        new InsertOneModel<>(new Document("_id", 5)),
                        new InsertOneModel<>(new Document("_id", 6)),
                        new UpdateOneModel<>(new Document("_id", 1),
                                new Document("$set", new Document("x", 2))),
                        new DeleteOneModel<>(new Document("_id", 2)),
                        new ReplaceOneModel<>(new Document("_id", 3),
                                new Document("_id", 3).append("x", 4))));

    }


}
