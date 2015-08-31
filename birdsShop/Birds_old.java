package birdsShop;

import java.lang.annotation.Retention;

public abstract class Birds_old {

    static double [][] storeDB  = new double[0][0];
    static String [] birdsDB = new String [0];

    static final int ID_NAME = 0;
    static final int PRICE = 1;
    static final int BALANCE = 2;
    static final int SALE = 3;
    static final int PROFIT = 4;

    static final int MORE = 1;
    static final int LESS = 0;
    static final int NOT_EXIST = -1;

    static int countField = 5;

    static int countGet = 0;
    static int countSet = 0;

//    public static void main(String[] args) {
//
//        printTitle("Add new name birds:");
//        createBird();
//
//        printTitle("Print all birds:");
//        printListBirds();
//
//        printTitle("Add record to store:");
//        createStore();
//
//        printTitle("Print all store:");
//        printAllStore();
//
//        printTitle("Rename some birds:");
//        rename();
//
//        printTitle("Print all store:");
//        printAllStore();
//
//        printTitle("Make sale:");
//        sale();
//
//        printTitle("Print changed store:");
//        printAllStore();
//
//        printTitle("Set new price:");
//        setPrice();
//
//        printTitle("Set new balance:");
//        setBalance();
//
//        printTitle("Print changed store:");
//        printAllStore();
//
//        printTitle("Print more then:");
//        getQuantity(500, MORE);
//
//        printTitle("Print less then:");
//        getQuantity(300, LESS);
//
//        printTitle("Total profit:");
//        System.out.printf("%.2f $;\n", getTotal(PROFIT));
//
//        printTitle("Total sales:");
//        System.out.printf("%.2f in;\n", getTotal(SALE));
//
//        printTitle("Total balance:");
//        System.out.printf("%.2f in;\n", getTotal(BALANCE));
//
//        printTitle("Delete all from StoreDB:");
//        deleteAllFromStore();
//
//        printTitle("Print all store:");
//        printAllStore();
//
//        printTitle("Checking incorrect entries:");
//        checkErrors();
//
//        System.out.println("\nCountGET: " + countGet);
//        System.out.println("CountSET: " + countSet);
//    }
//
//    static void setPrice(){
//        setPriceBird("Chicken", 254.45);
//        setPriceBird("Goose-1", 54.47);
//    }
//
//    static void setBalance(){
//        setBalanceBird("Turkey", 999.0);
//        setBalanceBird("Chicken", 333.0);
//    }
//
//    static void createBird(){
//        addNameToBirdsDB("Duck");
//        addNameToBirdsDB("Turkey");
//        addNameToBirdsDB("Chicken");
//        addNameToBirdsDB("Goose");
//        addNameToBirdsDB("Pingvin");
//        addNameToBirdsDB("Straus");
//    }

    static void createStore(){
        for(int i = 0; i < birdsDB.length; i++){
            String nameBird = getBirdName(i);
            addRecordToStoreDB(nameBird, random(), random()); // name, price, balance
        }
    }

    static void rename(){
        renameBird("Duck", "Duck-1");
        renameBird("Goose", "Goose-1");
    }

    static void sale(){
        makeSale("Duck-1", 12.0);
        makeSale("Turkey", 5.0);
        makeSale("Chicken", 130.0);
    }

    static void checkErrors(){
        deleteAllFromStore();
        sale();
    }

    static void addNameToBirdsDB(String nameBird){
        if (getNameBirdId(nameBird) == NOT_EXIST){
            writeNameToBirdDB(nameBird);
            printMessage("added", nameBird);
        } else {
            printMessage("nameExist", nameBird);
        }
    }

    private static void deleteAllFromStore() {
        for(int i = 0; i < birdsDB.length; i++){
            deleteRecordFromStoreDB(birdsDB[i]);
        }
    }

    private static void writeNameToBirdDB(String nameBird){
        int lastIndex = extendBirdsDB(); // +1
        birdsDB[lastIndex] = nameBird;
    }

    static void addRecordToStoreDB(String nameBird, double price, double balance){
        int nameID = getNameBirdId(nameBird);
        if(nameID != NOT_EXIST || foundRecordInStore(nameID) == NOT_EXIST){
            writeDataToStoreDB(nameID, price, balance);
            printMessage("added", nameBird);
        } else {
            printMessage("canNot", nameBird);
            return;
        }
    }

    static void makeSale(String nameBird, double qty){
        int id_row = existBirdInStore(nameBird);
        if(id_row == NOT_EXIST || !checkBalance(id_row, qty)){
            printMessage("errBalance", nameBird);
            return;
        } else {
            recordSaleToStore(id_row, qty);
            printMessage("sale", nameBird);
        }
    }

    static void renameBird(String oldName, String newName){
        int nameID = getNameBirdId(oldName);
        if(nameID == NOT_EXIST){
            printMessage("notFound", oldName);
            return;
        } else {
            birdsDB[nameID] = newName;
            printMessage("rename", oldName);
        }
    }

    static void setPriceBird(String nameBird, double newPrice){
        int id_row = existBirdInStore(nameBird);
        if(id_row != NOT_EXIST){
            setCellStoreDB(id_row, PRICE, newPrice);
            printMessage("set", nameBird);
        } else {
            printMessage("notFound", nameBird);
        }
    }

    static void setBalanceBird(String nameBird, double newBalance){
        int id_row = existBirdInStore(nameBird);
        if(id_row != NOT_EXIST){
            setCellStoreDB(id_row, BALANCE, newBalance);
            printMessage("set", nameBird);
        } else {
            printMessage("notFound", nameBird);
        }
    }

    static void deleteRecordFromStoreDB(String nameBird){
        if(existBirdInStore(nameBird) == NOT_EXIST){
            printMessage("canNot", nameBird);
            return;
        }
        storeDB = reduceArrayDB(nameBird);
        printMessage("del", nameBird);
    }

    static void getQuantity(int quantity, int trand){
        boolean flagNotFound = true;
        for (int i = 0; i < storeDB.length; i++){
            if (trand == LESS && getCellStoreDB(i, BALANCE) < quantity){ // less
                printStoreByRow(i);
                flagNotFound = false; // found
            } else if (trand == MORE && getCellStoreDB(i, BALANCE) > quantity){ // more
                printStoreByRow(i);
                flagNotFound = false; // found
            }
        } // for
        if (flagNotFound) {
            printMessage("notFound", "exist");
        }
    }

    static double getTotal(int fieldName){
        double total = calculateTotal(fieldName);
        return total;
    }

    private static double calculateTotal(int cell){
        double summa = 0;
        for(int row = 0; row < storeDB.length; row++){
            summa += getCellStoreDB(row, cell);
        }
        return summa;
    }

    private static void writeDataToStoreDB(double nameID, double price, double balance) {
        int lastRow = extendStoreDB();
        setCellStoreDB(lastRow, ID_NAME, nameID);
        setCellStoreDB(lastRow, PRICE, price);
        setCellStoreDB(lastRow, BALANCE, balance);
    }

    private static double [][] reduceArrayDB (String deleteName){
        int id_DeleteName = getNameBirdId(deleteName);
        double [][] newArr = new double [storeDB.length-1][];

        for (int i = 0, k = 0; i < storeDB.length; i++){
            if (getCellStoreDB(i, ID_NAME) == id_DeleteName){ // it should be removed
                continue;
            } //if
            newArr[k++] = storeDB[i];
        }
        return newArr;
    }

    private static boolean checkBalance(int id_row, double qty){
        if (getCellStoreDB(id_row, BALANCE) < qty){
            return false;
        } else {
            return true;
        }
    }

    private static void recordSaleToStore(int idRow, double qty){
        double newCountSale = getCellStoreDB(idRow, SALE) + qty;
        setCellStoreDB(idRow, SALE, newCountSale);

        double newCountBalance = getCellStoreDB(idRow, BALANCE) - qty;
        setCellStoreDB(idRow, BALANCE, newCountBalance);

        double newProfit = getCellStoreDB(idRow, PRICE) * qty;
        setCellStoreDB(idRow, PROFIT, newProfit);

    }

    private static void setCellStoreDB(int id_row, int id_cell, double number){
        countSet++;
        storeDB[id_row][id_cell] = number;
    }

    private static double getCellStoreDB(int id_row, int id_cell){
        countGet++;
        return storeDB[id_row][id_cell];
    }

    static String getBirdName(double id_name){
        return birdsDB[(int)id_name];
    }

    static int getNameBirdId(String nameBird){
        for (int id = 0; id < birdsDB.length; id++)
            if (birdsDB[id].equals(nameBird)){
                return id;
            }
        return NOT_EXIST;
    }

    private static int existBirdInStore(String nameBird){
        int nameID = getNameBirdId(nameBird);
        return foundRecordInStore(nameID);
    }

    private static int foundRecordInStore(int nameID){
        if(nameID == NOT_EXIST){
            return NOT_EXIST;
        }
        for (int i = 0; i < storeDB.length; i++){
            if (getCellStoreDB(i, ID_NAME) == nameID){
                return i;
            }
        }
        return NOT_EXIST;
    }

    private static int extendBirdsDB(){
        int newLenght = birdsDB.length + 1;
        String [] newArr = new String [newLenght];
        copyArray(birdsDB, newArr);
        birdsDB = newArr;
        return birdsDB.length - 1; // last index
    }

    private static int extendStoreDB() {
        int newLenght = storeDB.length + 1;
        double [][] newArr = new double [newLenght][];
        copyArray(storeDB, newArr);
        storeDB = newArr;
        int lastIndex = storeDB.length-1;
        storeDB[lastIndex] = new double[countField];
        return lastIndex; // last index
    }

    private static void copyArray(String [] srcArray, String [] destArray){
        for (int i = 0; i < srcArray.length; i++){
            destArray[i] = srcArray[i];
        }
    }

    private static void copyArray(double [][] srcArray, double [][] destArray){
        for (int i = 0; i < srcArray.length; i++){
            destArray[i] = srcArray[i];
        }
    }

    static void printListBirds (){
        for(int i = 0; i < birdsDB.length; i++){
            System.out.printf("%d. %s;\n", i+1, birdsDB[i]);
        }
    }

    static void printTitle(String title){
        System.out.println("\n" + title);
        System.out.println("-------------------------");
    }

    static void printAllStore(){
        for(int row = 0; row < storeDB.length; row++){
            printStoreByRow(row);
        }
    }

    static void printStoreByRow(int row){
        String nameBird = getBirdName(storeDB[row][ID_NAME]);
        System.out.printf("%s. %-12s | ", row+1,  nameBird);
        System.out.printf("price: %6s $/in | ", storeDB[row][PRICE]);
        System.out.printf("balance: %6s in | ", storeDB[row][BALANCE]);
        System.out.printf("sale: %6s in | ",    storeDB[row][SALE]);
        System.out.printf("profit: %8s $ |\n",  storeDB[row][PROFIT]);
    }

    static void printMessage(String index, String name){
        switch (index){
            case "nameExist": System.out.printf("%s already exist;\n", name); break;
            case "added": System.out.printf("%-8s - added succesfully; \n", name); break;
            case "rename": System.out.printf("%-8s - renamed succesfully;\n", name); break;
            case "notFound": System.out.printf("Bird %s not found;\n", name); break;
            case "canNot": System.out.printf("Can't execute query for %s, check entries;\n", name); break;
            case "del": System.out.printf("%-12s - deleted succesfully;\n", name); break;
            case "errBalance": System.out.printf("%-8s - error! Check name or quantity not available;\n", name); break;
            case "sale": System.out.printf("%-8s - sale succesfully;\n", name); break;
            case "set": System.out.printf("%-12s - change succesfully;\n", name); break;
            default: System.out.printf("%s - unknow message!!!\n", name);
        }
    }

    static double random(){
        long rand = (System.nanoTime() % 8) * 100 + 100; // 100 - 900
        return rand;
    }
}
