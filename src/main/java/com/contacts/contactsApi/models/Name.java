package com.contacts.contactsApi.models;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class Name {

    @NotNull
    @Size(max = 100)
    private String first;

    @NotNull
    @Size(max = 100)
    private String middle;

    @NotNull
    @Size(max = 100)
    private String last;

    public Name() {
        // Do not remove, required for deserialization
    }

    public Name(String first, String middle, String last){
        this.first = first;
        this.middle = middle;
        this.last = last;
    }

    /**
     * @return the first
     */
    public String getFirst() {
        return first;
    }

    /**
     * @return the middle
     */
    public String getMiddle() {
        return middle;
    }

    /**
     * @return the last
     */
    public String getLast() {
        return last;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(String first) {
        this.first = first;
    }

    /**
     * @param middle the middle to set
     */
    public void setMiddle(String middle) {
        this.middle = middle;
    }

    /**
     * @param last the last to set
     */
    public void setLast(String last) {
        this.last = last;
    }
}
