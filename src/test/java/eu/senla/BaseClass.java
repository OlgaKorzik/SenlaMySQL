package eu.senla;
import eu.senla.utils.DaoTable;
import eu.senla.utils.Log;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BaseClass {

   @BeforeEach
    private void getConnect(TestInfo testInfo){
       Log.info("-------Started test: "+ testInfo.getDisplayName()+" -------");
       assertNotNull(MyConnections.connect());
   }

   @AfterEach
    private void close(TestInfo testInfo){
       MyConnections.disconnect();
       DaoTable.closePreparedAndResult();
       Log.info("-------Finish test: "+testInfo.getDisplayName()+" -------");
   }
}
