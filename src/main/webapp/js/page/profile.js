
function initFormProfile() {
    const button = document.querySelector("[data-edit-profile-button]");
    const form = document.querySelector("[data-edit-profile-form]");
    if (button && form) {
        button.addEventListener('click', () => {
            form.classList.toggle("d-none");
        });
    }
}

window.addEventListener('load', () => {
    initFormProfile();
});