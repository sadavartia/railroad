package com.kiwiland.executor;

abstract class AbstractExecutor implements Executor {
    private final String commandLine;

    public AbstractExecutor(final String commandLine) {
        this.commandLine = commandLine;
    }

    protected final String getCommandLine() {
        return commandLine;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (commandLine == null ? 0 : commandLine.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractExecutor other = (AbstractExecutor) obj;
        if (commandLine == null) {
            if (other.commandLine != null) {
                return false;
            }
        } else if (!commandLine.equals(other.commandLine)) {
            return false;
        }
        return true;
    }

}
