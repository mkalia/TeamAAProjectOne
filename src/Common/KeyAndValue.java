package Common;// --== CS400 File Header Information ==--
// Name: Grant Parfrey
// Email: gparfrey@wisc.edu
// Team: AA
// TA: Sophie Stephenson
// Lecturer: Florian Heimerl
// Notes to Grader: n/a

//This class acts as a node for LinkedLists and stores a key along with a value
public class KeyAndValue<KeyType, ValueType> {
    private KeyType key;
    private ValueType value;

    //constructor that needs to be passed a key and value
    public KeyAndValue(KeyType iKey, ValueType iValue){
        key = iKey;
        value = iValue;
    }

    //getter method for key
    public KeyType getKey() {
        return key;
    }

    //getter method for value
    public ValueType getValue() {
        return value;
    }
}
