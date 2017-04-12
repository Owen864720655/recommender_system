# -*- coding: utf-8 -*-
"""
Calculate the popularity of each tag

Created on Wed Apr 12 20:27:07 2017

@author: Owen
"""

def TagPopularity(records):
    # If the tag is used by one user in one item, 
    # the popularity is added by one    
    tagFreq = dict();
    for user, item, tag in records:
        if tag not in tagFreq:
            tagFreq[tag] = 1;
        else:
            tagFreq[tag] += 1;
            
    return tagFreq;
