package gg.jte.generated.ondemand;
import it.rattly.todo.views.TodoView;;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,2,2,2,16,16,31,31,32,32,33,33,34,34,39,39,39,40,40,40,40,40,40,40,40,40,40,40,42,42,43,43,43,44,44,46,46,47,47,47,48,48,52,52,53,53,54,54,55,55,58};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, TodoView todoView) {
		jteOutput.writeContent("\r\n<html>\r\n<head>\r\n    <title>TodoList</title>\r\n    <link rel=\"stylesheet\" href=\"https://rsms.me/inter/inter.css\">\r\n    <link rel=\"stylesheet\" href=\"assets/puppertino/css/newfull.css\">\r\n    <link rel=\"stylesheet\" href=\"webjars/flexboxgrid/6.3.0/css/flexboxgrid.min.css\">\r\n    <link rel=\"stylesheet\" href=\"assets/app.css\">\r\n\r\n    <script src=\"assets/puppertino/js/actions.js\"></script>\r\n    <script src=\"assets/puppertino/js/modals.js\"></script>\r\n    <script src=\"assets/puppertino/js/segmented_controls.js\"></script>\r\n    <script src=\"assets/puppertino/js/tabs.js\"></script>\r\n    ");
		jteOutput.writeContent("\r\n    <script src=\"assets/app.js\"></script>\r\n</head>\r\n\r\n<body>\r\n<div class=\"p-layout default\">\r\n    <div class=\"row center-xs\">\r\n        <h1>TODO List</h1>\r\n    </div>\r\n\r\n    <div class=\"row center-xs\">\r\n        <input type=\"text\" class=\"p-form-text p-form-no-validate\" id=\"insert\" placeholder=\"Insert todo...\">\r\n        <button class=\"p-btn\" id=\"submit\" onclick=\"add()\">Add</button>\r\n    </div>\r\n\r\n    ");
		for (int i = 0; i < todoView.getTodos().size(); i++) {
			jteOutput.writeContent("\r\n        ");
			if (todoView.shouldAddRow()) {
				jteOutput.writeContent("\r\n            ");
				jteOutput.writeContent(" <div class=\"row center-xs\"> ");
				jteOutput.writeContent("\r\n        ");
			}
			jteOutput.writeContent("\r\n\r\n        <div class=\"p-card card\" style=\"margin-left: 15px; margin-right: 15px\">\r\n            <div class=\"p-card-content\">\r\n                <h3 class=\"p-card-title\">Todo</h3>\r\n                <p class=\"p-card-text\">");
			jteOutput.setContext("p", null);
			jteOutput.writeUserContent(todoView.getTodos().get(i).getValue());
			jteOutput.writeContent("</p>\r\n                <p class=\"p-card-text\"");
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(todoView.getTodos().get(i).getId())) {
				jteOutput.writeContent(" id=\"");
				jteOutput.setContext("p", "id");
				jteOutput.writeUserContent(todoView.getTodos().get(i).getId());
				jteOutput.setContext("p", null);
				jteOutput.writeContent("\"");
			}
			jteOutput.writeContent(">Completed: ");
			jteOutput.setContext("p", null);
			jteOutput.writeUserContent(todoView.getTodos().get(i).getDone() ? "✓" : "✘");
			jteOutput.writeContent("</p>\r\n\r\n                ");
			if (!todoView.getTodos().get(i).getDone()) {
				jteOutput.writeContent("\r\n                    <button class=\"p-btn\" onclick=\"complete(");
				jteOutput.setContext("button", "onclick");
				jteOutput.writeUserContent(todoView.getTodos().get(i).getId());
				jteOutput.writeContent(")\">Complete</button>\r\n                ");
			}
			jteOutput.writeContent("\r\n\r\n                ");
			if (todoView.getTodos().get(i).getDone()) {
				jteOutput.writeContent("\r\n                    <button class=\"p-btn\" onclick=\"remove(");
				jteOutput.setContext("button", "onclick");
				jteOutput.writeUserContent(todoView.getTodos().get(i).getId());
				jteOutput.writeContent(")\">Delete</button>\r\n                ");
			}
			jteOutput.writeContent("\r\n            </div>\r\n        </div>\r\n\r\n        ");
			if (todoView.shouldEndRow() || (i + 1) == todoView.getTodos().size()) {
				jteOutput.writeContent("\r\n            ");
				jteOutput.writeContent(" </div> ");
				jteOutput.writeContent("\r\n        ");
			}
			jteOutput.writeContent("\r\n    ");
		}
		jteOutput.writeContent("\r\n</div>\r\n</body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		TodoView todoView = (TodoView)params.get("todoView");
		render(jteOutput, jteHtmlInterceptor, todoView);
	}
}
