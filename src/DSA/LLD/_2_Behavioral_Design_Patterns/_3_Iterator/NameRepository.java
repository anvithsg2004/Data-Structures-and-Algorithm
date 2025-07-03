package DSA.LLD._2_Behavioral_Design_Patterns._3_Iterator;

public class NameRepository implements MyCollection {
    private String[] names = {"Ram", "Shyam", "Geeta"};

    @Override
    public MyIterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements MyIterator {
        int index = 0;

        public boolean hasNext() {
            return index < names.length;
        }

        public String next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
