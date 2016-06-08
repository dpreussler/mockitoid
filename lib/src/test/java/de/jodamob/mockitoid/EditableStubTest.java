package de.jodamob.mockitoid;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import android.text.InputFilter;

import org.junit.Test;

public class EditableStubTest {

    EditableStub tested = new EditableStub("test");

    @Test
    public void length() {
        assertThat(tested.length()).isEqualTo(4);
    }

    @Test
    public void append() {
        assertThat(tested.append("ed").toString()).isEqualTo("tested");
    }

    @Test
    public void append_with_index() {
        assertThat(tested.append("ededed", 0, 2).toString()).isEqualTo("tested");
    }

    @Test
    public void charAt() {
        assertThat(tested.charAt(2)).isEqualTo('s');
    }

    @Test
    public void getFilters() {
        assertThat(tested.getFilters()).isNotNull();
    }

    @Test
    public void setFilters() {
        InputFilter[] filters = { mock(InputFilter.class) };
        tested.setFilters(filters);
        assertThat(tested.getFilters()).isEqualTo(filters);
    }

    @Test
    public void delete() {
        assertThat(tested.delete(0,2).toString()).isEqualTo("st");
    }

    @Test
    public void insert() {
        assertThat(tested.insert(1,"eee").toString()).isEqualTo("teeeest");
    }

    @Test
    public void insert_with_index() {
        assertThat(tested.insert(1,"eee", 0, 1).toString()).isEqualTo("teest");
    }

    @Test
    public void replace() {
        assertThat(tested.replace(0, 1,"R").toString()).isEqualTo("Rest");
    }

    @Test
    public void replace_with_index() {
        assertThat(tested.replace(0, 1,"RRR", 0, 1).toString()).isEqualTo("Rest");
    }

    @Test
    public void subSequence() {
        assertThat(tested.subSequence(0, 2).toString()).isEqualTo("te");
    }

    @Test
    public void clear() {
        tested.clear();
        assertThat(tested.toString()).isEqualTo("");
    }



}