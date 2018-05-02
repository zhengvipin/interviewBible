let CONSTANT = {
    DATA_TABLES: {
        DEFAULT_OPTION: { //DataTables初始化选项
            language: { // 汉化
                //url: "zh_CN.txt"         
                "sProcessing": "处理中...",
                "sLengthMenu": "每页 _MENU_ 项",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "当前显示第 _START_ 至 _END_ 项，共 _TOTAL_ 项。",
                "sInfoEmpty": "当前显示第 0 至 0 项，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页",
                    "sJump": "跳转"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },
            // 开启服务端分页——分页、取数据等等的都放到服务端去
            serverSide: true,
            // 载入数据的时候是否显示“载入中”
            //processing: true,
            // 首次加载的数据条数
            pageLength: 10,
            // 全局控制列表的所有排序功能——排序操作在服务端进行，所以可以关了
            ordering: true,
            // 取消默认排序查询,否则复选框一列会出现小箭头
            //order: [],
            // 初始化默认排序字段和排序方式
            aaSorting: [[0, "asc"]],
            // 初始化时指定列不可排序
            //aoColumnDefs: [ { "bSortable": false, "aTargets": [ 0 , 1 , 2 ] }]
            // 定义翻页组件的样式
            //  simple -  只有上一页和下一页2个按钮
            //  simple_numbers   – 上一页,下一页和页码
            //  full – 首页,末页,上一页,下一页4个按钮
            //  full_numbers   – 全部按钮和页面
            pagingType: "full_numbers",
            // 是否自动调整列宽
            autoWidth: false,
            // 是否开启状态保存，当选项开启的时候会使用一个cookie保存表格展示的信息的状态，例如分页信息，展示长度，过滤和排等
            stateSave: true,
            // 为奇偶行加上样式，兼容不支持CSS伪类的场合
            stripeClasses: ["odd", "even"],
            // 禁用原生搜索
            searching: false
            // 分页控件的布局调整
            //l - Length changing 改变每页显示多少条数据的控件
            //f - Filtering input 即时搜索框控件
            //t - The Table 表格本身
            //i - Information 表格相关信息控件
            //p - Pagination 分页控件
            //r - pRocessing 加载等待显示信息
            //< > - div elements 代表一个div元素 <div><div>
            //<"#id" > - div with an id 指定了id的div元素 <div id='id'><div>
            //<"class" > - div with a class 指定了样式名的div元素 <div class='class'><div>
            //<"#id.class" > - div with an id and class 指定了id和样式的div元素 <div id='id' class='class'><div>
            //sDom:'<"#oDiv"l<"clear">>rt<"bottom"ip<"clear">>',
        }
    }
};