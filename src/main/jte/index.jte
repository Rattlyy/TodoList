@import it.rattly.todo.views.TodoView;

@param TodoView todoView

<html>
<head>
    <title>TodoList</title>
    <link rel="stylesheet" href="https://rsms.me/inter/inter.css">
    <link rel="stylesheet" href="assets/puppertino/css/newfull.css">
    <link rel="stylesheet" href="webjars/flexboxgrid/6.3.0/css/flexboxgrid.min.css">
    <link rel="stylesheet" href="assets/app.css">

    <script src="assets/puppertino/js/actions.js"></script>
    <script src="assets/puppertino/js/modals.js"></script>
    <script src="assets/puppertino/js/segmented_controls.js"></script>
    <script src="assets/puppertino/js/tabs.js"></script>
    <%-- <script src="webjars/feather-icons/4.28.0/dist/feather.js"></script> --%>
    <script src="assets/app.js"></script>
</head>

<body>
<div class="p-layout default">
    <div class="row center-xs">
        <h1>TODO List</h1>
    </div>

    <div class="row center-xs">
        <input type="text" class="p-form-text p-form-no-validate" id="insert" placeholder="Insert todo...">
        <button class="p-btn" id="submit" onclick="add()">Add</button>
    </div>

    @for(int i = 0; i < todoView.getTodos().size(); i++)
        @if(todoView.shouldAddRow())
            @raw <div class="row center-xs"> @endraw
        @endif

        <div class="p-card card" style="margin-left: 15px; margin-right: 15px">
            <div class="p-card-content">
                <h3 class="p-card-title">Todo</h3>
                <p class="p-card-text">${todoView.getTodos().get(i).getValue()}</p>
                <p class="p-card-text" id="${todoView.getTodos().get(i).getId()}">Completed: ${todoView.getTodos().get(i).getDone() ? "✓" : "✘"}</p>

                @if(!todoView.getTodos().get(i).getDone())
                    <button class="p-btn" onclick="complete(${todoView.getTodos().get(i).getId()})">Complete</button>
                @endif

                @if(todoView.getTodos().get(i).getDone())
                    <button class="p-btn" onclick="remove(${todoView.getTodos().get(i).getId()})">Delete</button>
                @endif
            </div>
        </div>

        @if(todoView.shouldEndRow() || (i + 1) == todoView.getTodos().size())
            @raw </div> @endraw
        @endif
    @endfor
</div>
</body>
</html>