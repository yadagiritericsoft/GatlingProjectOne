var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "17",
        "ok": "16",
        "ko": "1"
    },
    "minResponseTime": {
        "total": "292",
        "ok": "292",
        "ko": "10352"
    },
    "maxResponseTime": {
        "total": "10352",
        "ok": "1235",
        "ko": "10352"
    },
    "meanResponseTime": {
        "total": "1074",
        "ok": "494",
        "ko": "10352"
    },
    "standardDeviation": {
        "total": "2345",
        "ok": "357",
        "ko": "0"
    },
    "percentiles1": {
        "total": "315",
        "ok": "315",
        "ko": "10352"
    },
    "percentiles2": {
        "total": "407",
        "ok": "407",
        "ko": "10352"
    },
    "percentiles3": {
        "total": "3058",
        "ok": "1235",
        "ko": "10352"
    },
    "percentiles4": {
        "total": "8893",
        "ok": "1235",
        "ko": "10352"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 13,
    "percentage": 76
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 3,
    "percentage": 18
},
    "group4": {
    "name": "failed",
    "count": 1,
    "percentage": 6
},
    "meanNumberOfRequestsPerSecond": {
        "total": "1.062",
        "ok": "1",
        "ko": "0.062"
    }
},
contents: {
"req_goto-home-page-66b3a": {
        type: "REQUEST",
        name: "Goto Home Page",
path: "Goto Home Page",
pathFormatted: "req_goto-home-page-66b3a",
stats: {
    "name": "Goto Home Page",
    "numberOfRequests": {
        "total": "9",
        "ok": "8",
        "ko": "1"
    },
    "minResponseTime": {
        "total": "314",
        "ok": "314",
        "ko": "10352"
    },
    "maxResponseTime": {
        "total": "10352",
        "ok": "1235",
        "ko": "10352"
    },
    "meanResponseTime": {
        "total": "1737",
        "ok": "660",
        "ko": "10352"
    },
    "standardDeviation": {
        "total": "3075",
        "ok": "444",
        "ko": "0"
    },
    "percentiles1": {
        "total": "320",
        "ok": "318",
        "ko": "10352"
    },
    "percentiles2": {
        "total": "1235",
        "ok": "1231",
        "ko": "10352"
    },
    "percentiles3": {
        "total": "6705",
        "ok": "1235",
        "ko": "10352"
    },
    "percentiles4": {
        "total": "9623",
        "ok": "1235",
        "ko": "10352"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 5,
    "percentage": 56
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 3,
    "percentage": 33
},
    "group4": {
    "name": "failed",
    "count": 1,
    "percentage": 11
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.562",
        "ok": "0.5",
        "ko": "0.062"
    }
}
    },"req_goto-home-page--f77fe": {
        type: "REQUEST",
        name: "Goto Home Page Redirect 1",
path: "Goto Home Page Redirect 1",
pathFormatted: "req_goto-home-page--f77fe",
stats: {
    "name": "Goto Home Page Redirect 1",
    "numberOfRequests": {
        "total": "8",
        "ok": "8",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "292",
        "ok": "292",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "407",
        "ok": "407",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "328",
        "ok": "328",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "46",
        "ok": "46",
        "ko": "-"
    },
    "percentiles1": {
        "total": "307",
        "ok": "307",
        "ko": "-"
    },
    "percentiles2": {
        "total": "333",
        "ok": "333",
        "ko": "-"
    },
    "percentiles3": {
        "total": "407",
        "ok": "407",
        "ko": "-"
    },
    "percentiles4": {
        "total": "407",
        "ok": "407",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 8,
    "percentage": 100
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.5",
        "ok": "0.5",
        "ko": "-"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
