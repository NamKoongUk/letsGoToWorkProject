(function (global, factory) {
    typeof exports === 'object' && typeof module !== 'undefined' ? module.exports = factory() :
    typeof define === 'function' && define.amd ? define(factory) :
    (global = global || self, (global.FullCalendarLocales = global.FullCalendarLocales || {}, global.FullCalendarLocales.ko = factory()));
}(this, function () { 'use strict';

    var ko = {
        code: "ko",
        buttonText: {
        	prevYear: "<<",
            prev: "<",
            next: ">",
            nextYear: ">>",
            today: "Today",
            month: "월",
            week: "주",
            day: "일",
            list: "일정"
        },
        weekLabel: "주",
        allDayText: "종일",
        eventLimitText: "개",
        noEventsMessage: "일정이 없습니다"
    };

    return ko;

}));
