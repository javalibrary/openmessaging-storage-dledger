package io.openmessaging.storage.dleger.store;

import io.openmessaging.storage.dleger.MemberState;
import io.openmessaging.storage.dleger.entry.DLegerEntry;

public abstract class DLegerStore {


    public MemberState getMemberState() {
        return null;
    }
    public abstract DLegerEntry appendAsLeader(DLegerEntry entry);


    public abstract DLegerEntry appendAsFollower(DLegerEntry entry, long leaderTerm, String leaderId);

    public abstract DLegerEntry get(Long index);

    public abstract long getCommittedIndex();

    public void updateCommittedIndex(long term, long committedIndex) {

    }

    public abstract long getLegerEndTerm();
    public abstract long getLegerEndIndex();

    public abstract long getLegerBeginIndex();

    protected void updateLegerEndIndexAndTerm() {
        if (getMemberState() != null) {
            getMemberState().updateLegerIndexAndTerm(getLegerEndIndex(), getLegerEndTerm());
        }
    }

    public void flush() {

    }

    public long truncate(DLegerEntry entry, long leaderTerm, String leaderId) {
        return -1;
    }

    public void startup() {

    }
    public void shutdown() {

    }
}