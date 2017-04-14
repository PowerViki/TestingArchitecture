# coding:utf-8
import os
import sys
reload(sys)
sys.setdefaultencoding('utf8')

BondFeature_DICT = {'T50043': '国债期货合约基本信息', 'T50041': '国债期货行情查询', 'T50044': '请求国债期货相关的现券',
            'T50047': '国债期货分时行情查询', 'T50048': '国债期货5分钟K线数据查询',
            'T50049': '国债期货日K线数据查询', 'T50054': '请求计算器需要的基础数据',
            'T50064': '查询Tick',
            'T50199': '查询交易所成交','T50247': '查询估结算',
            'T50253': '成交统计国债期货相关券行情查询','T50255': '活跃金融债查询',
            'T50330': 'CTD分析','T50620': '历史价差日线数据','T50658': '查询国债期货的活跃券',
            'T50659': '查询国债期货的自选券', 'T50666': '查询某一成交时刻国债期货价格', 'T50667': '查询历史波动率',
            'T55300': '查询指定债券的区间信息', 'T61160': '请求国债期货历史结算价'}

MM_DICT = {'T57060': '查询MM报价状态', 'T57100': '新建报价', 'T57101': '修改报价',
            'T57102': '发送/撤销/删除报价', 'T57103': '分页查询发送的报价',
            'T57310': '查询资产类型', 'T57311': '查询指定资产的标签',
            'T57312': '查询用户保存的资产标签','T57313': '保存用户设置的资产标签',
            'T57314': '查询用户保存的筛选标签','T57315': '保存用户设置的筛选标签',
            'T57316': '查询用户保存的省份筛选','T57320': '查询指定资产的报价类型',
            'T57916': '设置MM联系方式状态'}

Secondary_DICT = {'T50088': ' ', 'T50098': '个券详情', 'T50121': '请求最优报价',
            'T50122': '请求市场动向', 'T50124': '请求市场动向',
            'T50128': '查询国债期货相关现券成交', 'T50184': '查询交易所最优行情',
            'T50187': '我的关注分组排序','T50190': '查询CFETS行情最优',
            'T52005': '查询IRS的marketstream qb2.1.2及之后的版本请求最优报价',
            'T53004': '债券首页的收益率曲线','T53010': '查询QBA成交日线',
            'T53014': '所有估值报价','T53032': '成交分析','T55110': '查询Sumscope推荐债券列表',
            'T55922': '请求共享报价数据', 'T57902': '报价统计实时查询'}

Login_DICT = {'Login': '登录'}

def get_current_path():
    current_path = os.getcwd().replace("\\", "/")
    print(current_path)
    return current_path


def delete_file(file_name):
    if os.path.exists(file_name):
        os.remove(file_name)


class log2Csv:
    def __init__(self):
        self.log_file = "../script/report.txt"
        self.csv_file = "../report/TestResult.csv"

    def generate(self):
        delete_file(self.csv_file)
        output = open(self.csv_file, 'a')
        header = ""
        count = 0
        f = open(self.log_file)
        for line in f:
            value = ""
            count = count + 1
            data = str(line).strip()
            if len(data)>0:
                arr = data.split(' ')
                for i in range(0, len(arr)):
                    text = str(arr[i])
                    index1 = text.find('[')
                    index2 = text.find(']')
                    header = header + "," + str(text[0:index1])
                    value = value + "," + str(text[index1+1:index2])
                    if i > 5 or i == 2:
                        value += "%"
                    if i > 2 and i < 6:
                        header += "(s)"
                header = "Scenario"+","+"Description" + header

            for key in BondFeature_DICT:
                if str(key) in str(line):
                    scenario = "BondFeature"
                    desc = str(BondFeature_DICT.get(key)).encode('utf-8')
                    break

            for key1 in Login_DICT:
                if str(key1) in str(line):
                    scenario = "Login"
                    desc = str(Login_DICT.get(key)).encode('utf-8')
                    break

            for key2 in MM_DICT:
                if str(key2) in str(line):
                    scenario = "MM"
                    desc = str(MM_DICT.get(key2)).encode('utf-8')
                    break

            for key3 in Secondary_DICT:
                if str(key3) in str(line):
                    scenario = "SecondaryMarket"
                    desc = str(Secondary_DICT.get(key3)).encode('utf-8')
                    break
            if len(value)>0:
                value = scenario+","+desc + value
            if count == 1:
                output.write(header + "\n")
            #if value[0:1] == ",":
                #value = value[1:len(value)]
            if len(value)>0:
                output.write(value + "\n")
        output.close()

if __name__ == '__main__':
    obj = log2Csv()
    obj.generate()