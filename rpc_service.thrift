namespace py class_sheduling_service
namespace java ClassShedulingService
namespace js ClassShedulingService

enum Subject{
    HISTORY = 0b000001,
    PHYSICAL = 0b000010,
    GEOGRAPHY = 0b000100,
    POLITICAL = 0b001000,
    BIOLOGICAL = 0b010000,
    CHEMISTRY = 0b100000
}

//statusCode 0:正常 -1：异常

struct StageOneResultOfClassStrategy{
    1:list<list<list<i32>>>   walkingclassCombinationSolution //2*3*2的数组 科目组合的结果
    2:list<list<list<i32>>>   walkingclassCombinationSelection    //2*3*2 对应的科目组合
    3:list<list<double>>   walkingclassCombinationStudentAverageNumner //3*4   每个科目班级的平均人数
    4:list<list<i32>>   walkingclassCombinationClassNumber  //3*4   每个科目的班级数量
    5:list<i32>   minClassNumber //4    对应的最少班级数
    6:list<i32> walkingclassSubject //4 对应的科目
}
struct StageTwoResultOfClassStrategy{
    1:list<list<list<list<i32>>>>   walkingclassHPSolution  //2*2*3*2   历史/物理 相应科目组合的学生人数
    2:list<list<list<i32>>>   walkingclassCombinationSelection    //2*3*2 对应的科目组合
    3:list<list<double>>   walkingclassHPStudentAverageNumber  //2*3   历史/物理   每组学生的平均人数
    4:list<list<i32>>   walkingclassHPClassNumber   //2*3   历史/物理   班级数
    5:list<i32>   minClassNumber  //2   对应的最少班级数
}

struct ClassStrategyRule{
    2:map<i16,i32> subjectTeacherNumber //科目组合对应的老师数量
    3:map<i16,i32> sectionStudentNumber //科目组合对应的学生数量
    4:list<i32> maxAndMinClassStudentNumber //一个普通班级最大/最小人数
    5:i32   runing_time=50  //算法运行时间的度量，值越大，一次运行时间越长，获得好结果的概率提升
}

struct  ClassStrategyModifyResult{
    1:i32   taskId  //任务id
    2:i32   stage   //需要修改的阶段
    5:StageOneResultOfClassStrategy StageOneResultOfClassStrategy   //第一阶段所要修改的结果.....
    6:StageTwoResultOfClassStrategy StageTwoResultOfClassStrategy
}

struct ResultOfClassStrategyCreateTask{
    1:i32 statusCode    //0-正常 -1-出错
    2:i32 taskId    //任务id
    3:string   message  //返回的消息
}

struct ResultOfClassStrategyDelTask{
    1:i32 statusCode    //0-正常 -1-出错
    2:string   message  //返回的消息
}

struct ResultOfClassStrategyRunTask{
    1:i32 statusCode    //0-运行成功 -1-出错
    2:string message    
}
struct ResultOfClassStrategyGetTasksStatus{
    1:i32   statusCode
    2:map<i32,i16>  tasksStatusMap  //{taskId:status}   每个任务对应的状态  0-完成  1-正在运行  -1-出现了错误
    3:map<i32,i16>  tasksStageMap   //{taksId:stage}    每个任务目前的阶段
    4:string message
}
struct ResultOfClassStrategyGetTaskResult{
    1:i32   statusCode
    2:string    message
    3:i32   taskId
    4:i32   stage
    5:StageOneResultOfClassStrategy StageOneResultOfClassStrategy
    6:StageTwoResultOfClassStrategy StageTwoResultOfClassStrategy
}
struct ResultOfClassStrategyModifyTaskResult{
    1:i32   statusCode
    2:string    message
}
struct ResultOfGetClassStrategyRule{
    1:i32   statusCode
    2:string    message
    3:ClassStrategyRule rule
}

service ClassSchedulignService{
    bool ping()

    //创建分班任务
    ResultOfClassStrategyCreateTask createTaskForClassStrategy(1:ClassStrategyRule rule)

    //删除分班任务
    ResultOfClassStrategyDelTask delTaskForClassStrategy(1:i32  taskId)

    //运行分班任务
    ResultOfClassStrategyRunTask runTaskForClassStrategy(1:i32 taskId,2:i32 stage)

    //获取现有任务及其运行情况
    ResultOfClassStrategyGetTasksStatus getTasksStatusForClassStrategy()

    //获取任务结果
    ResultOfClassStrategyGetTaskResult getTaskResultForClassStrategy(1:i32 taskId,2:i32 stage)

    //修改结果
    ResultOfClassStrategyModifyTaskResult modifyTaskResultForClassStrategy(1:ClassStrategyModifyResult classStrategyModifyResult)

    //获取分班任务的现存规则
    ResultOfGetClassStrategyRule getClassStrategyRule(1:i32 taskId)
}