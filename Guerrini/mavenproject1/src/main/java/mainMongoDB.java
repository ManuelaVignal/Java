
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author tss
 */
public class mainMongoDB {

    public static void main(String[] args) {

//connessione
        MongoClient mongo = new MongoClient("localhost", 27017);
        //schema db
        MongoDatabase database = mongo.getDatabase("dbregistro");

        //tabella collection
        MongoCollection<Document> registri = database.getCollection("registri");

        //ora siamo sulla tabella collection registri
        //creo record document
        Document document = new Document("titolo", "TSS java")
                .append("codice", "C1-112-2022-0")
                .append("anno gestione", "2021-2022");

        // inserisco record
        registri.insertOne(document);

        Document document2 = new Document("titolo", "TSS java")
                .append("codice", "C1-113-2022-0")
                .append("anno gestione", "2021-2022");

        Document document3 = new Document("titolo", "TSS java")
                .append("codice", "C1-114-2022-0")
                .append("anno gestione", "2021-2022");

        List<Document> list = new ArrayList<Document>();
        list.add(document2);
        list.add(document3);
        //inserisco arraylist di record documenti
        registri.insertMany(list);

//abbiamo dei documenti
        // Getting the iterable object
        FindIterable<Document> results = registri.find();
        int i = 1;
        // Getting the iterator
        Iterator doc = results.iterator();
        while (doc.hasNext()) {
            System.out.println(doc.next());
            i++;
        }
    }
