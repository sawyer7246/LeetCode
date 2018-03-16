# Find valid Repayment
简单得说，就是你借了b和q各3万块钱, 现在要从还款日开始每天还1万, 如果不还对你的坏印象分会增加.
- 任意一个没还, 加1分
- 同时没还, 还要另加1分
- 连续3天没换, 另加1分

 
## 概括
    找到所有小于等于3分的还钱方法. 
    
## 解题思想
### 穷举法
穷举出每天所有的可能还钱的方式,验证是否合法.

- 第一步, 还钱策略建模
    
    对于每天还钱的4种策略进行建模; 

- 第二步, 惩罚分建模

    有两种惩罚.首先是对于还不还的惩罚, 其次对于连续三天有不还情况的惩罚.
    
- 第三步, 穷举策略

    按照每天有四种可能的情况下, n天的话所有可能有n^4中情况.
    如何确定这个n, 可以根据启发: 最少每天还0w, 然而直接就3分爆了, 那么我们算每天只还1w, 最多4天爆, 所以我们就算4天.
    当然, 我的算法是优化过的穷举法, 如果发现已经*爆*了, 就不会再在这个策略分支往下找可能的组合了, 所以我就算不找到 n=4 也无所谓,
    因为之后的东西不会有进入循环, 代码中我写了6层循环, 和4层没什么区别.

哎，考试只有30分钟, 题目中还夹杂了非常多的冗余信息浪费你时间, 交卷时也就大概建完模, 算法才写了1/3, 更何况还有很多Bug调试.


Anyway, 总结如下:
1. 首先要培养自己从杂乱的信息中找到关键的能力.
2. 其次, python写得不熟练,对于一些细节问题的处理还是不能得心应手.

 
```python 

# 四种策略
#还b的钱 [-1,0]
#还q的钱[0,-1]
#都不还[0,0]
#都还[-1,-1]
all_stra = [(0,0),(-1,0),(0,-1),(-1,-1)]

# 不同还钱方式的惩罚手段
all_stra_points = {(-1,0):1, (0,-1):1, (0,0):3, (-1,-1):0 }

b_mnt = 3
q_mnt = 3

def isAnswer(currentBRemain, currentQRemain, currentPoints):
    if currentBRemain==0 and currentQRemain==0 and currentPoints<=3:
        return True
    return False

def sumPoints(stra_arr):
    return sum([i for i in map(lambda x : all_stra_points[x],stra_arr)])+is3Day(stra_arr)

def sumRemains(stra_arr,index):
    return sum([i for i in map(lambda x : x[index], stra_arr)])

def is3Day(stra_arr):
    continue_3 = 0
    for tmp_pay_stra in stra_arr:
        if 0 in tmp_pay_stra:
            continue_3 += 1
            if continue_3 >= 3:
                return 1
        else:
            continue_3 = 0
    return 0
    
strategy_index = 0
def isStrategyOver(stra_arr):
    tem_b_remains = b_mnt + sumRemains(stra_arr,0)
    tem_q_remains = q_mnt + sumRemains(stra_arr,1)
    tem_Points = sumPoints(stra_arr)
    if isAnswer(tem_b_remains,tem_q_remains, tem_Points):
        global strategy_index
        strategy_index = strategy_index+1
        print("strategy_index %s"%strategy_index)
        print("b_remains:{0},q_remains:{1},Points:{2}".format(tem_b_remains,tem_q_remains,tem_Points))
        print(str(stra_arr))
    if tem_Points > 3:
        return True
    return False
        
        
for stra_tmp_1 in all_stra:
    if isStrategyOver([stra_tmp_1]):
        continue
    for stra_tmp_2 in all_stra:
        if isStrategyOver([stra_tmp_1,stra_tmp_2]):
            continue
        for stra_tmp_3 in all_stra:
            if isStrategyOver([stra_tmp_1,stra_tmp_2,stra_tmp_3]):
                continue
            for stra_tmp_4 in all_stra:
                if isStrategyOver([stra_tmp_1,stra_tmp_2,stra_tmp_3,stra_tmp_4]):
                    continue
                for stra_tmp_5 in all_stra:
                    if isStrategyOver([stra_tmp_1,stra_tmp_2,stra_tmp_3,stra_tmp_4,stra_tmp_5]):
                        continue
                    for stra_tmp_6 in all_stra:
                        if isStrategyOver([stra_tmp_1,stra_tmp_2,stra_tmp_3,stra_tmp_4,stra_tmp_5, stra_tmp_6]):
                            continue

```
