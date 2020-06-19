public class KeyValuePair{
    public String key;
    public Object value;

    public KeyValuePair(String key,Object value){
        this.key = key;
        this.value = value;
    }

    public String getKey(){ return this.key;}
    public Object getItem(){return this.value;}
    public boolean setKey(String key){return (this.key = key) != null;}// return true if item is not null
    public boolean setItem(Object item){return (this.value = item) != null;}// return treu if ite is not null
}