
function initSearchBar() {
    const searchBar = document.querySelector("input[data-search-bar-games]");
    if (searchBar) {
        const submit = searchBar.nextElementSibling;
        if (submit) {
            submit.addEventListener('click', () => {
                if (searchBar.value.trim()) {
                    location.href = "/game/search/" + searchBar.value;
                }
            });
        }
    }
}

window.addEventListener('load', () => {
    initSearchBar();
});