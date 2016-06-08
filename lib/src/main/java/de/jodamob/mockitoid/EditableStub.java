package de.jodamob.mockitoid;

import android.text.Editable;
import android.text.InputFilter;

import java.util.Collections;

/**
 * editable stub with some basic implementations
 * does not implement the span related methods
 */
class EditableStub implements Editable {

    private StringBuilder value;
    private InputFilter[] filters = new InputFilter[0];

    public EditableStub(String s) {
        value = new StringBuilder(s);
    }

    @Override
    public Editable replace(int st, int en, CharSequence source, int start, int end) {
        return replace(st, en, source.subSequence(start, end));
    }

    @Override
    public Editable replace(int st, int en, CharSequence text) {
        value.replace(st, en, text.toString());
        return this;
    }

    @Override
    public Editable insert(int where, CharSequence text, int start, int end) {
        value.insert(where, text, start, end);
        return this;
    }

    @Override
    public Editable insert(int where, CharSequence text) {
        value.insert(where, text);
        return this;
    }

    @Override
    public Editable delete(int st, int en) {
        value.delete(st, en);
        return this;
    }

    @Override
    public Editable append(CharSequence text) {
        value.append(text);
        return this;
    }

    @Override
    public Editable append(CharSequence text, int start, int end) {
        value.append(text, start, end);
        return this;
    }

    @Override
    public Editable append(char text) {
        value.append(text);
        return this;
    }

    @Override
    public void clear() {
        value = new StringBuilder();
    }

    @Override
    public void clearSpans() {
        // not implemented
    }

    @Override
    public void setFilters(InputFilter[] filters) {
        this.filters = filters;
    }

    @Override
    public InputFilter[] getFilters() {
        return filters;
    }

    @Override
    public void getChars(int start, int end, char[] dest, int destoff) {
        value.getChars(start, end, dest, destoff);
    }

    @Override
    public void setSpan(Object what, int start, int end, int flags) {
        // not implemented
    }

    @Override
    public void removeSpan(Object what) {
        // not implemented
    }

    @Override
    public <T> T[] getSpans(int start, int end, Class<T> type) {
        // not implemented
        return (T[]) Collections.emptyList().toArray();
    }

    @Override
    public int getSpanStart(Object tag) {
        // not implemented
        return 0;
    }

    @Override
    public int getSpanEnd(Object tag) {
        // not implemented
        return 0;
    }

    @Override
    public int getSpanFlags(Object tag) {
        // not implemented
        return 0;
    }

    @Override
    public int nextSpanTransition(int start, int limit, Class type) {
        // not implemented
        return 0;
    }

    @Override
    public int length() {
        return value.length();
    }

    @Override
    public char charAt(int index) {
        return value.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return value.subSequence(start, end);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
