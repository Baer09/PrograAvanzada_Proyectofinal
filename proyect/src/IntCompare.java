public interface IntCompare {
    
    /**
     * compare 2 objects
     * @param intSort
     * @return returns negative if a < b, or  a = b and positive if a > b
     * @throws Exception
     */
    public int compare(Object a, Object b) throws Exception;
}