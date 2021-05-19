function getQuestions(callbackFunction) {
    $.getJSON("GetQuestionsController", {}, callbackFunction);
}