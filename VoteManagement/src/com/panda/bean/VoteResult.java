package com.panda.bean;

/**
 * Created by Panda on 2016/5/14.
 */

import java.util.List;
public class VoteResult {
    private Vote vote;
    private List<VoteOption> voteOptions;         //所有选项集合
    public Vote getVote() {
        return vote;
    }
    public void setVote(Vote vote){
        this.vote = vote;
    }
    public List<VoteOption> getVoteOptions(){
        return voteOptions;
    }
    public void setVoteOptions(List<VoteOption> voteOptions){
        this.voteOptions = voteOptions;
    }
}
