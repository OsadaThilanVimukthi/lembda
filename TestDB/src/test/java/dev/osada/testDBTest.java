package dev.osada;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class testDBTest {

    @Test
    void ListHelloUsers(){
        var user=new testDB ();
        Assertions.assertEquals(1,user.createTableInDatabase());

    }
    @Test
    void InsertHelloUsers(){
        var users=new testDB ();

        Assertions.assertEquals(1,users.insertDataIntoTable(1, "thilan",12));
    }
}