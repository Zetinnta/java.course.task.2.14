package ru.skypro;

import java.util.Objects;

public class StringListImpl implements StringList {

    private static final int initialLength = 10;

    private int capacity;

    private final String[] arr;

    public StringListImpl() {
        arr = new String[initialLength];
        capacity = 0;
    }

    public StringListImpl(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("The list's size has to be positive!");
        }
        arr = new String[length];
        capacity = 0;
    }

    @Override
    public String add(String item) {
        if (capacity >= arr.length) {
            throw new IllegalArgumentException("The list is full!");
        }
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("You can not add 'Null' into the list!");
        }
        return arr[capacity++] = item;
    }

    @Override
    public String add(int index, String item) {
        if (capacity >= arr.length) {
            throw new IllegalArgumentException("The list is full!");
        }
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("You can not add 'Null' into the list!");
        }
        if (index < 0) {
            throw new IllegalArgumentException("Index has to be positive!");
        }
        if (index > capacity) {
            throw new IllegalArgumentException("Index: " + index + ", Size: " + capacity);
        }
        for (int i = capacity; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = item;
        capacity++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("You can not have 'Null' in the list!");
        }
        if (index < 0) {
            throw new IllegalArgumentException("Index has to be positive!");
        }
        if (index >= capacity) {
            throw new IllegalArgumentException("Index: " + index + ", Size: " + capacity);
        }
        return arr[index] = item;
    }

    @Override
    public String remove(String item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("You can not have 'Null' in the list!");
        }
        int removable = -1;
        for (int i = 0; i < capacity; i++) {
            if (arr[i].equals(item)) {
                removable = i;
                break;
            }
        }
        if (removable == -1) {
            throw new IllegalArgumentException("Element not found!");
        }
        return remove(removable);
    }

    @Override
    public String remove(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index has to be positive!");
        }
        if (index >= capacity) {
            throw new IllegalArgumentException("Index: " + index + ", Size: " + capacity);
        }
        String removedItem = arr[index];
        for (int i = index; i < capacity - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[--capacity] = null;
        return removedItem;
    }

    @Override
    public boolean contains(String item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("You can not have 'Null' in the list!");
        }
        for (int i = 0; i < capacity; i++) {
            if (arr[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("You can not have 'Null' in the list!");
        }
        int index = -1;
        for (int i = 0; i < capacity; i++) {
            if (arr[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(String item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("You can not have 'Null' in the list!");
        }
        int index = -1;
        for (int i = capacity - 1; i >= 0; i--) {
            if (arr[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public String get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index has to be positive!");
        }
        if (index >= capacity) {
            throw new IllegalArgumentException("Index: " + index + ", Size: " + capacity);
        }
        return arr[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (size() != otherList.size()) {
            return false;
        }
        for (int i = 0; i < capacity; i++) {
            if (!arr[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            arr[i] = null;
        }
        capacity = 0;
    }

    @Override
    public String[] toArray() {
        String[] result = new String[capacity];
        for (int i = 0; i < capacity; i++) {
            result[i] = arr[i];
        }
        return result;
    }
}
