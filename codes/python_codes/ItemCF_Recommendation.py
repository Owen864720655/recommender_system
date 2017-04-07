# -*- coding: utf-8 -*-
"""
Created on Fri Apr 07 22:22:50 2017

@author: Owen
"""

def ItemCF_Recommendation(train, user_id, W, K):
    rank = dict()
    ru = train[user_id]
    for i, pi in ru.items():
        for j, wj in sorted(W[i].items(), key = itemgetter(1), reverse = True)[0:K]:
            if j in ru:
                continue
            rank[j] += pi*wj
    return rank
    
            