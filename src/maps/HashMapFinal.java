package maps;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapFinal<K, V> {
    ArrayList<LinkedList<Entity>> list;
    private int size = 0;
    private float loadFactor =0.5f;
    public HashMapFinal() {
        list = new ArrayList<>();
        for(int i=0;i<10;i++) {
            list.add(new LinkedList<>());
        }
    }

    private class Entity {
        K key;
        V value;
        public Entity(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value) {
        if (key == null) {
            // Handle null key — store at index 0
            LinkedList<Entity> entities = list.get(0);
            for (Entity entity : entities) {
                if (entity.key == null) {
                    entity.value = value; // update existing null-key entry
                    return;
                }
            }
            // Add new null-key entry
            entities.add(new Entity(null, value));
            size++;
            if ((float) size / list.size() > loadFactor) {
                reHash();
            }
            return;
        }

        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<Entity> entities = list.get(hash);
        for (Entity entity : entities) {
            if (entity.key.equals(key)) {
                entity.value = value;
                return;
            }
        }

        entities.add(new Entity(key, value));
        size++;
        if ((float) size / list.size() > loadFactor) {
            reHash();
        }
    }


    private void reHash() {
        System.out.println("we are now rehashing");
        ArrayList<LinkedList<Entity>> old = list;
        list = new ArrayList<>();
        size = 0;
        for(int i=0;i<old.size()*2;i++) {
            list.add(new LinkedList<>());
        }
        for(LinkedList<Entity> entities: old) {
            for(Entity entity: entities) {
                put(entity.key, entity.value);
            }
        }
    }

    public V get(K key) {
        if (key == null) {
            LinkedList<Entity> entities = list.get(0);
            for (Entity entity : entities) {
                if (entity.key == null) {
                    return entity.value;
                }
            }
            return null;
        }

        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<Entity> entities = list.get(hash);
        for (Entity entity : entities) {
            if (entity.key.equals(key)) {
                return entity.value;
            }
        }
        return null;
    }


    public void remove(K key) {
        if (key == null) {
            LinkedList<Entity> entities = list.get(0);
            Entity target = null;
            for (Entity entity : entities) {
                if (entity.key == null) {
                    target = entity;
                    break;
                }
            }
            if (target != null) {
                entities.remove(target);
                size--;
            }
            return;
        }

        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<Entity> entities = list.get(hash);
        Entity target = null;
        for (Entity entity : entities) {
            if (entity.key.equals(key)) {
                target = entity;
                break;
            }
        }
        if (target != null) {
            entities.remove(target);
            size--;
        }
    }


    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for(LinkedList<Entity> entities: list) {
            for(Entity entity: entities) {
                builder.append(entity.key);
                builder.append(" = ");
                builder.append(entity.value);
                builder.append(" , ");
            }
        }
        builder.append("}");
        return builder.toString();
    }
}
