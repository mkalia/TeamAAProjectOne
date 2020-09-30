package Common;

import java.util.ArrayList;

import Backend2.Book;

public class MapAndKeys {

    MapADT<Long, Book> hashTable;
    ArrayList<Long> keys;

    public MapAndKeys(MapADT<Long, Book> hashTable, ArrayList<Long> keys) {
        this.hashTable = hashTable;
        this.keys = keys;
    }

    /**
     * @return the hashTable
     */
    public MapADT<Long, Book> getHashTable() {
        return hashTable;
    }

    /**
     * @return the keys
     */
    public ArrayList<Long> getKeys() {
        return keys;
    }
}