//时间格式化
function dateFormat(fmt, date) {
    let ret;
    const opt = {
        "Y+": date.getFullYear().toString(),        // 年
        "m+": (date.getMonth() + 1).toString(),     // 月
        "d+": date.getDate().toString(),            // 日
        "H+": date.getHours().toString(),           // 时
        "M+": date.getMinutes().toString(),         // 分
        "S+": date.getSeconds().toString()          // 秒
        // 有其他格式化字符需求可以继续添加，必须转化成字符串
    };
    for (let k in opt) {
        ret = new RegExp("(" + k + ")").exec(fmt);
        if (ret) {
            fmt = fmt.replace(ret[1], (ret[1].length == 1) ? (opt[k]) : (opt[k].padStart(ret[1].length, "0")))
        }
        ;
    }
    ;
    return fmt;
}

//页面跳转
function rout(msg) {
    // console.log(vue.count)
    // let pathName=msg.innerHTML
    //
    // // location.href="/toComment"
}

//鼠标移入li标签
function mouthOver(li) {
    li.style.overflow = "visible"
}

//鼠标移出li标签
function mouseOut(li) {
    li.style.overflow = "hidden"
}

//窗口大小变化监控
function reNavWith() {
    let navwith = 60 * (document.getElementById("nav_list").childElementCount);//20为每个a标签的宽度,50为动态调整
    let headWith = document.body.clientWidth / 2;
    let startWith = headWith - navwith;
    let boundaryWith = document.body.clientWidth * 0.2
    if (startWith < boundaryWith) {
        document.getElementById("nav_list").style.left = (boundaryWith + "px")

    }
    document.getElementById("nav_list").style.left = (headWith - navwith + "px")
}

window.onload = function () {
    reNavWith()
}

window.onresize = function () {
    reNavWith()

}

//控制导航栏透明度
window.onscroll = function () {
    let scrollTop = document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop;
    if (scrollTop < 10) {
        document.getElementsByClassName("nav-list")[0].style.opacity = 1;
    } else if (scrollTop < 100) {
        document.getElementsByClassName("nav-list")[0].style.opacity = 0.8;
    } else {
        document.getElementsByClassName("nav-list")[0].style.opacity = 0.7;
    }
};

let vue = new Vue({
    el: "#app",
    data() {
        return {
            totalPages: "",//取后端返回内容的总页数
            list: [], //后端返回的数组
            count: 1,
            loading: false,
            pollings: [
                "/img/lun1.jpg", "/img/lun2.jpg", "/img/lun3.jpg", "/img/lun4.jpg"

            ],//轮播图路径数组
            recommend: [
                "springboot事务的详细介绍", "springboot事务的详细介绍", "springboot事务的详细介绍", "springboot事务的详细介绍", "springboot事务的详细介绍", "springboot事务的详细介绍", "springboot事务的详细介绍",
            ]//文章推荐列表
        };
    },
    created() {
        this.getMessage();
    },
    computed: {
        noMore() {
            //当起始页数大于总页数时停止加载
            return this.count >= this.totalPages+1 ;
        },
        disabled() {
            return this.loading || this.noMore;
        }
    },
    methods: {
        load() {
            console.log("开始加载下一页")
            //滑到底部时进行加载
            this.loading = true;
            setTimeout(() => {
                this.count += 1; //页数+1
                this.getMessage(); //调用接口，此时页数+1，查询下一页数据
                this.loading = false ;
            }, 2000);
        },

        getMessage() {
            let params = {
                "pageNum": this.count,
                "pageSize": 10 //每页查询条数
            };
            let that=this
            axios.post("/article/selectArticles", params).then(res => {
                let dataArticles = res.data.list;
                console.log(res.data);
                for (let i = 0; i < dataArticles.length; i++) {
                    //日期格式转化
                    let dateCreat = new Date(dataArticles[i].articleDate);
                    let date = dateFormat("YYYY-mm-dd HH:MM:SS", dateCreat)
                    dataArticles[i].articleDate = date
                    // console.log( dataArticles[i])
                }
                that.list = that.list.concat(dataArticles); //因为每次后端返回的都是数组，所以这边把数组拼接到一起
                that.totalPages = res.data.pages;
                that.loading = false;
            })
                .catch(err => {
                    console.log(err);

                });
            console.log(this.list);

        }
    }
})