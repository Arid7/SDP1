// Autor: Celso Paim 
// Data: Maio/2026
// Objectivo: conectar e manipular uma base de dados MongoDB simples via Java

import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.MongoClient;
import java.net.UnknownHostException;
import org.bson.Document;

public class DemoConexaoMongoDB {
    public static void main( String args[] ) throws UnknownHostException, MongoException {
        // abrir uma conexao com o servidor do MongoDB
        MongoClient mongoClient = MongoClients.create( "mongodb://localhost:27017" );
        
        // seleccionar a bd, que sera criada caso ainda nao exista 
        MongoDatabase database = mongoClient.getDatabase( "contactos_bdNoSQL" );

        // seleccionar uma coleccao para armazenar os dados e tambem a criar caso ainda nao exista
        MongoCollection<Document> collection = database.getCollection( "contactos" );
        
        // criar um documento que ira representar um contacto
        Document doc1 = new Document();
        doc1.put( "id", 1 );
        doc1.put( "nome", "Teresa Tati" );
        doc1.put( "email", "bt@gmail.com" );
        doc1.put( "telefone", 965300537 );
        
        // criar um sub-documento, com a morada do contacto que na verdade e outro documento
        Document doc1_morada = new Document( "rua", "Rua Duque de Chiazi" )
                                    .append( "numero", 220 )
                                    .append( "cidade", "Menongue" );

        // anexar o sub-documento ao documento
        doc1.put( "endereco", doc1_morada );

        // inserir o documento na coleccao
        collection.insertOne( doc1 );

        // criar outro documento (representando outro contacto)
        Document doc2 = new Document( "id", 2 )
                                .append( "nome", "Cidalia Ribeiro" )
                                .append( "email", "cr@gmail.com" )
                                .append( "telefone", 965300270 );
        // inserir o outro documento na coleccao, desta vez sem o campo morada
        collection.insertOne( doc2 );
        
        // consultar a BD procurando por algum contacto com base no seu telefone, ira retornar apenas o primeiro contacto que corresponda a condicao de pesquisa
        Document docTemp = new Document();
        docTemp.put( "telefone", 965300270 );
        Document docEncontrado = collection.find( docTemp ).first();
        
        // imprimir o objecto documento procurado (poderia invocar o println com docEncontrado.toJson() para imprimir no formato JSON)
        System.out.println( docEncontrado );
    }
}