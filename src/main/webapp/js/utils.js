function getQuestions(questions_total, callbackFunction) {
    $.getJSON("GetQuestionsController", {questions_total: questions_total}, callbackFunction);
}