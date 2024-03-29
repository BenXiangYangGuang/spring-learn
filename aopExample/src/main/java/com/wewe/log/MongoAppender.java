// package com.wewe.log;
//
// import com.mongodb.BasicDBObject;
// import com.mongodb.MongoClient;
// import com.mongodb.MongoClientURI;
// import com.mongodb.client.MongoCollection;
// import com.mongodb.client.MongoDatabase;
// import org.apache.log4j.AppenderSkeleton;
// import org.apache.log4j.spi.LoggingEvent;
//
// /**
//  * Author: fei2
//  * Date:  18-9-13 下午1:52
//  * Description: 存储访问log4j日志到mongodb;项目用self4
//  * Refer To:
//  */
// public class MongoAppender  extends AppenderSkeleton {
//
//     private MongoClient mongoClient;
//     private MongoDatabase mongoDatabase;
//     private MongoCollection<BasicDBObject> logsCollection;
//
//     private String connectionUrl;
//     private String databaseName;
//     private String collectionName;
//
//     @Override
//     protected void append(LoggingEvent loggingEvent) {
//
//         if(mongoDatabase == null) {
//             MongoClientURI connectionString = new MongoClientURI(connectionUrl);
//             mongoClient = new MongoClient(connectionString);
//             mongoDatabase = mongoClient.getDatabase(databaseName);
//             logsCollection = mongoDatabase.getCollection(collectionName, BasicDBObject.class);
//         }
//         logsCollection.insertOne(BasicDBObject.parse(loggingEvent.getMessage().toString()));
//
//     }
//
//     @Override
//     public void close() {
//         if(mongoClient != null) {
//             mongoClient.close();
//         }
//     }
//
//     @Override
//     public boolean requiresLayout() {
//         return false;
//     }
//
//     public String getConnectionUrl() {
//         return connectionUrl;
//     }
//
//     public void setConnectionUrl(String connectionUrl) {
//         this.connectionUrl = connectionUrl;
//     }
//
//     public String getDatabaseName() {
//         return databaseName;
//     }
//
//     public void setDatabaseName(String databaseName) {
//         this.databaseName = databaseName;
//     }
//
//     public String getCollectionName() {
//         return collectionName;
//     }
//
//     public void setCollectionName(String collectionName) {
//         this.collectionName = collectionName;
//     }
// }
