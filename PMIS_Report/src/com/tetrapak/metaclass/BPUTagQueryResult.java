package com.tetrapak.metaclass;

import java.util.Map;

import com.tetrapak.domain.bpu.BPUAnalogTag;

public class BPUTagQueryResult {
    private BPUAnalogTag tag;
    /**
     * Tag Value DateTime => Value Pairs
     * */
    private Map<String, String> tagValue;

    public BPUAnalogTag getTag() {
	return tag;
    }

    public void setTag(BPUAnalogTag tag) {
	this.tag = tag;
    }

    public Map<String, String> getTagValue() {
	return tagValue;
    }

    public void setTagValue(Map<String, String> tagValue) {
	this.tagValue = tagValue;
    }
}
